package com.nqy.mycode.annotations;

import java.lang.annotation.*;

/**
 * this is the example code that process the annotation
 * @see <a href="http://en.wikipedia.org/wiki/Java_annotation">Wiki</a>
 *
 */
public class ProcessingExample {
    public static void main(String[] args) {
        Class<SetCustomAnnotation> classObj = SetCustomAnnotation.class;
        readAnnotation(classObj);
    }

    private static void readAnnotation(Class<SetCustomAnnotation> classObj) {
        if(classObj.isAnnotationPresent(TypeHeader.class)){
            Annotation annotation = classObj.getAnnotation(TypeHeader.class);
            TypeHeader header = (TypeHeader) annotation;

            System.out.println("Developer: " + header.developer());
            System.out.println("Last Modified: " + header.lastModified());

            // teamMembers returned as String []
            System.out.print("Team members: ");
            for (String member : header.teamMembers())
                System.out.print(member + ", ");
            System.out.print("\n");

            System.out.println("Meaning of Life: "+ header.meaningOfLife());
        }
    }

    // This is the annotation to be processed
    // Default for Target is all Java Elements
    // Change retention policy to RUNTIME (default is CLASS)
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD,ElementType.TYPE})
    public @interface TypeHeader{
        // Default value specified for developer attribute
        String developer() default "Unknown";
        String lastModified();
        String [] teamMembers();
        int meaningOfLife();
    }

    // This is the annotation being applied to a class
    @TypeHeader(developer = "Bob",lastModified = "2015.5.25",teamMembers = {"Jack","Tim"},meaningOfLife = 2)
    public class SetCustomAnnotation {
        // Class contents go here
    }

}
