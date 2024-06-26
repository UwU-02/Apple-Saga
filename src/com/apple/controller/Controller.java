package com.apple.controller;

import java.sql.Connection;

abstract class Controller {

	public static Connection conn;

    public abstract void connectToDatabase();

}
