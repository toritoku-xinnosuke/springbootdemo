package com.cjd.springbootdemo.neo4jdemo;

import lombok.extern.log4j.Log4j2;
import org.neo4j.driver.*;
import org.neo4j.driver.Record;
import org.neo4j.fabric.stream.StatementResult;

import static org.neo4j.driver.Values.parameters;
//@Log4j2
public class HelloNeo4j implements AutoCloseable{
    private Driver driver;

    public HelloNeo4j(String uri,String user, String password){
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user,password));
    }

    @Override
    public void close() throws Exception{
        driver.close();
    }

    public void printGreeting(final String message){
        try (Session session = driver.session()){
            String greeting = session.writeTransaction(new TransactionWork<String>() {
                @Override
                public String execute(Transaction transaction) {
                    Result result = transaction.run("CREATE (a:GREETING) " + "SET a.message = $message " + "RETURN a.message + ', from node ' + id(a)",parameters( "message", message ));

                    return result.single().get(0).asString();
                }
            });
            System.out.println(greeting);
            //log.info(greeting);

        }
    }

    public void getGretting(){
        try(Session session = driver.session()){
            Result result = session.run("MATCH (a:GREETING) RETURN a.message as msg");
            //result.single().fields().get(0);
            while (result.hasNext()){
                Record record = result.next();
                System.out.println(record.get(0).toString());
            }
            //System.out.println(res);
        }

    }



    public static void main(String[] args) throws Exception {
        try (HelloNeo4j greeter = new HelloNeo4j("bolt://localhost:7687","neo4j","123456")){
            //greeter.printGreeting("hello,world");
            greeter.getGretting();
        }
    }

}
