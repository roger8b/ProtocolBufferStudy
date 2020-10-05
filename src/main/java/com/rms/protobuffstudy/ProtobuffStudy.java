package com.rms.protobuffstudy;


import java.io.*;

import static com.rms.protobuffstudy.AddressBookProtos.*;

public class ProtobuffStudy {

    public static void main(String[] args) throws Exception {
        System.out.println("Start Protobuff Person");
        String file = "./person";

        /*
          Create Person
         */
        Person roger = Person.newBuilder()
                .setId(1)
                .setName("roger")
                .setEmail("roger.8b@gmail.com")
                .build();
        AddressBookProtos.AddressBook addressBook = AddressBookProtos.AddressBook
                .newBuilder()
                .addPeople(roger).build();
        /*
          Save in file
         */
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        addressBook.writeTo(fileOutputStream);

        /*
          Recover file
         */
        AddressBookProtos.AddressBook deserialized
                = AddressBookProtos.AddressBook.newBuilder()
                .mergeFrom(new FileInputStream(file)).build();

        /*
          Print Result
         */
        System.out.println(deserialized);
    }
}
