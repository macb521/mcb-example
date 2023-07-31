package com.example.design.mode.action.status;

/**
 * 预定房间可以入住和退订
 */
public class BookedState implements State {

    Room hotelMangement;

    public BookedState(Room hotelMangement) {
        this.hotelMangement = hotelMangement;
    }

    @Override
    public void bookRoom() {
        System.out.println("该房间已被预定");
    }

    @Override
    public void unsubscribeRoom() {
        System.out.println("退订成功");
        hotelMangement.setState(hotelMangement.getFreeTimeState());
    }

    @Override
    public void checkInRoom() {
        System.out.println("入住成功");
        hotelMangement.setState(hotelMangement.getCheckInState());
    }

    @Override
    public void checkOutRoom() {
        System.out.println("您还没有入住");
    }


}
