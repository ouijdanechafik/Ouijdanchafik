import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





	public class Etudiantmanager{
		
		
		public int addetudiant(int age, String prenom, String nom,int id,String login,String password) {
			DbInteraction.connect();
			String sql="insert into etudiant (age,prenom,nom,id,login,password) values ("+age+",'"+prenom+"','"+nom+"',"+id+",'"+login+"','"+password+"')";
			int nb= DbInteraction.Maj(sql);
			DbInteraction.disconnect();
			return nb;}

	    public int deleteEtudiant(int id)
	    {DbInteraction.connect();
	    int nb= DbInteraction.Maj("delete from etudiant where id="+id);
	    DbInteraction.disconnect();
	    return nb;
	    }
	    public Etudiant findEtudiantByid(int id) throws SQLException
	    {DbInteraction.connect();
	    Etudiant u=null;
	      ResultSet rs=DbInteraction.select("select * from etudiant where id="+id);
	    
	    if(rs.next())
	    {
	       u = new Etudiant();
	    try {
			u.setId( rs.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			u.setPrenom(rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			u.setNom(rs.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			u.setAge(rs.getInt(4));
	    DbInteraction.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	    }
	return u;
	    
		
	    }
	    public List<Etudiant> all_Etudiant(){
        List<Etudiant> tabe=new ArrayList<Etudiant>();
	    DbInteraction.connect();
	    ResultSet rs=DbInteraction.select("select * from etudiant");
	    try {
			while(rs.next())
			{Etudiant e=new Etudiant();
			e.setId(rs.getInt(1));
			e.setNom(rs.getNString(2));
			e.setPrenom(rs.getString(3));
			e.setAge(rs.getInt(4));
			
			tabe.add(e);}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return tabe;
	    }
	    
	    
	    public Etudiant authentification(String log, String pass)
		{
			Etudiant e1=null;
			DbInteraction.connect();
			ResultSet rs = DbInteraction.select("select * from etudiant where login='"+log+"' and password='"+pass+"'");
			try {
				if(rs.next())
				{
					e1=new Etudiant();
					e1.setId(rs.getInt(1));
					e1.setNom(rs.getNString(2));
					e1.setPrenom(rs.getString(3));
					e1.setAge(rs.getInt(4));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return e1;
			
		}
	}	
	    
	    
	    
	    
	    