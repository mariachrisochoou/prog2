public static boolean logUser(Connection con) throws SQLException {
    String query = "select  username , password from  user, where username =user";
    try (Statement stmt = con.createStatement()) {
      ResultSet ps = stmt.executeQuery(query);
      while (ps.next()) {
        String userName = ps.getString("username");
        int passWord = ps.getInt("password");
	      boolean flag = flase;
	      if (userName != null){
		      flag = true;
	      }
	      return flag;
      }
    } catch (SQLException e) {
      JDBCTutorialUtilities.printSQLException(e);
    }
  }
