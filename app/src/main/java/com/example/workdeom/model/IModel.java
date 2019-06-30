package com.example.workdeom.model;

import com.example.workdeom.bean.User;
import com.example.workdeom.bean.User2;

public interface IModel {
    void getDataM(ICallBask<User> iCallBask);
    void getDataM2(ICallBask<User2> iCallBask);
}
