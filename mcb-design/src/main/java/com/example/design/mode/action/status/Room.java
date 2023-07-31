package com.example.design.mode.action.status;

import lombok.Data;

@Data
public class Room {

    State freeTimeState;//空闲

    State checkInState;//入住

    State bookedState;//预定

    State state;

    public Room() {
        freeTimeState = new FreeTimeState(this);
        checkInState = new CheckInState(this);
        bookedState = new BookedState(this);

        state = freeTimeState;  //初始状态为空闲
    }

    public void bookRoom() {
        state.bookRoom();
    }

    public void unsubscribeRoom() {
        state.unsubscribeRoom();
    }


    public void checkInRoom() {
        state.checkInRoom();

    }

    @Override
    public String toString() {
        return "该房间的状态是:" + getState().getClass().getName();
    }

    public void checkOutRoom() {
        state.checkOutRoom();

    }


}
