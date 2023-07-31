package com.example.design.mode.action.cor;

public class Test {
    public static void main(String[] args) {
        Leader instructor = new Instructor("陈毅");       //辅导员
        Leader departmentHead = new DepartmentHead("王明");    //系主任
        Leader dean = new Dean("张强");      //院长
        Leader president = new President("王晗");     //校长

        instructor.setSuccessor(departmentHead);       //辅导员的后续者是系主任
        departmentHead.setSuccessor(dean);             //系主任的后续者是院长
        dean.setSuccessor(president);                  //院长的后续者是校长

        //请假3天的请假条
        LeaveNode leaveNode1 = new LeaveNode(3, "张三");
        instructor.handleRequest(leaveNode1);

        //请假9天的请假条
        LeaveNode leaveNode2 = new LeaveNode(9, "李四");
        instructor.handleRequest(leaveNode2);

        //请假15天的请假条
        LeaveNode leaveNode3 = new LeaveNode(15, "王五");
        instructor.handleRequest(leaveNode3);

        //请假20天的请假条
        LeaveNode leaveNode4 = new LeaveNode(20, "赵六");
        instructor.handleRequest(leaveNode4);
    }

}
