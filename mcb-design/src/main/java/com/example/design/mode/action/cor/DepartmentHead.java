package com.example.design.mode.action.cor;
/**
 * @author chunbo.ma.o
 */
public class DepartmentHead extends AbstractLeader {

    public static final int INT = 7;

    public DepartmentHead(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveNode leaveNode) {
        //小于7天系主任审批
        if (leaveNode.getNumber() <= INT) {
            System.out.println("系主任" + name + "审批" + leaveNode.getPerson() + "同学的请假条,请假天数为" + leaveNode.getNumber() + "天。");
        } else if (this.successor != null) {
            this.successor.handleRequest(leaveNode);
        }

    }
}