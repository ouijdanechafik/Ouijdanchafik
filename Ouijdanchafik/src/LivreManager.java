
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivreManager {
	
	public int addLivre(int idLivre, String titre, String auteur,String catégorie) {
		DbInteraction.connect();
		String sql="insert into livre (idLivre,titre,auteur,catégorie) values ("+idLivre+",'"+titre+"','"+auteur+"','"+catégorie+"')";
		int nb= DbInteraction.Maj(sql);
		DbInteraction.disconnect();
		return nb;}

    public int deleteLivre(int id)
    {DbInteraction.connect();
    int nb= DbInteraction.Maj("delete from livre where id="+id);
    DbInteraction.disconnect();
    return nb;
    }
    public Livre findLivreByCatégorie(String catégorie) 
    {DbInteraction.connect();
    Livre l=null ;
      ResultSet rs=DbInteraction.select("select * from livre where catégorie="+catégorie);
    
    try {
		if(rs.next())
		{
		   l = new Livre();
		   l.setIdLivre(rs.getInt(1));
		   l.setTitre(rs.getString(2));
		   l.setAuteur(rs.getString(3));
		   l.setCatégorie(rs.getString(4));
		   DbInteraction.disconnect();
 
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	  return l ;
   
	 
    }
    public List<Livre> all_livres(){
    List<Livre> tabl=new ArrayList<Livre>();
    DbInteraction.connect();
    ResultSet rs=DbInteraction.select("select * from livre");
 
		try {
			while(rs.next())
			{Livre l=new Livre();
			l.setIdLivre(rs.getInt(1));
			l.setTitre(rs.getString(2));
			l.setAuteur(rs.getString(3));
			l.setCatégorie(rs.getString(4));
			tabl.add(l);}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
    return tabl;
    
    }



}
