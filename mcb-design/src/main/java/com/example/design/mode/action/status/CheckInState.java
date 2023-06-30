package com.example.design.mode.action.status;

/**
 * 入住可以退房
 */

public class CheckInState implements State {

    Room hotelManageMent;


    public CheckInState(Room hotelManageMent) {
        this.hotelManageMent = hotelManageMent;
    }

    @Override
    public void bookRoom() {
        System.out.println("该房间已经入住");
    }

    @Override
    public void unsubscribeRoom() {
        System.out.println("该房间已经入住");
    }

    @Override
    public void checkInRoom() {
        System.out.println("该房间已经入住");
    }

    @Override
    public void checkOutRoom() {
        System.out.println("退订成功");
        hotelManageMent.setState(hotelManageMent.getFreeTimeState());
    }


}
