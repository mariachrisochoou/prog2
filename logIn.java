public boolean logIn(String username,String password) {
    DbConnection dbconnection = new DbConnection("jdbc:mysql://127.0.0.1:3306/db","test","testforjava");
    			Connection con = dbconnection.getConnection();
     String sql = "SELECT username , passw
                   FROM user,
                   WHERE USERNAME = uname";
                   boolean flag;

				   		try {
				   			PreparedStatement ps = conn.prepareStatement(sql);

				   			ps.getString(1, username);
				   			ps.getString(2, password);
				   			flag = true;
				   		} catch (SQLException e) {
				   			flag = false;
				   		} catch (Exception e) {
				   			flag = false;
		}
		return flag;
	}