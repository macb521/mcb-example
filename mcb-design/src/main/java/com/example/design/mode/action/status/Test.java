package com.example.design.mode.action.status;

public class Test {
    public static void main(String[] args) {

        test1();
    }

    public static void test1() {
        Room[] rooms = new Room[3];

        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room();
        }

        rooms[0].bookRoom();    //预订
        rooms[0].checkInRoom();   //入住
        rooms[0].bookRoom();    //预订
        System.out.println(rooms[0]);
        System.out.println("---------------------------");

        //第二间房
        rooms[1].checkInRoom();
        rooms[1].bookRoom();
        rooms[1].checkOutRoom();
        rooms[1].bookRoom();

        rooms[2].checkOutRoom();
        rooms[2].unsubscribeRoom();
        rooms[2].bookRoom();
        System.out.println(rooms[1]);
    }


}
