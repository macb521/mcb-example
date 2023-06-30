package com.example.design.mode.action.status;

public interface State {

    /**
     * 预定房间
     */
    void bookRoom();

    /**
     * 退订房间
     */
    void unsubscribeRoom();

    /**
     * 入住
     */
    void checkInRoom();

    /**
     * 退房
     */
    void checkOutRoom();
}
