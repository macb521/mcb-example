package com.example.design.mode.action.status;

/**
 * 空闲房间可以入住和预定
 */

public class FreeTimeState implements State {

    Room hotelManagement;


    public FreeTimeState(Room hotelManagement) {
        this.hotelManagement = hotelManagement;
    }

    @Override
    public void bookRoom() {
        System.out.println("您已成功预定");
        hotelManagement.setState(hotelManagement.getBookedState());
    }

    @Override
    public void unsubscribeRoom() {
        System.out.println("您还没有预定");
    }

    @Override
    public void checkInRoom() {
        System.out.println("您已成功入住");
        hotelManagement.setState(hotelManagement.getCheckInState());
    }

    @Override
    public void checkOutRoom() {
        System.out.println("您还没有入住");
    }


}
