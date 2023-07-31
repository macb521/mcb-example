package com.example.design.mode.action.cor;

public class Dean extends Leader {

    public Dean(String name) {
        super(name);
    }

    public void handleRequest(LeaveNode LeaveNode) {
        if (LeaveNode.getNumber() <= 10) {   //小于10天院长审批
            System.out.println("院长" + name + "审批" + LeaveNode.getPerson() + "同学的请假条,请假天数为" + LeaveNode.getNumber() + "天。");
        } else if (this.successor != null) {
            this.successor.handleRequest(LeaveNode);
        }

    }

}