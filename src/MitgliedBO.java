
public class MitgliedBO {
	
	//Attribute
	private static MitgliedBO uniqueInstance;
	
	//Konstruktor
	private MitgliedBO(){
		
	}
	
	//Methoden
	public static MitgliedBO getInstance(){
		if(uniqueInstance==null){
			uniqueInstance=new MitgliedBO();
		}
		return uniqueInstance;
	}
	
	/**
	 * Eine neue Leihe hinzuf�gen
	 * @param m Medium
	 */
	public void addLeihe(MitgliedDTO mg, MediumDTO m){
		LeiheDTO l = new LeiheDTO(mg, m);
		LeiheDAO.getInstance().create(l);
		m.setEntliehen(true);
		MediumDAO.getInstance().update(m);
	}
	
	/**
	 * Holt eine Leihe anhand eines Mediums
	 * @param m Medium
	 * @return gefundene Leihe oder Null
	 */
	public LeiheDTO getLeihe(MediumDTO m){
		return LeiheDAO.getInstance().read(m);
	}
	
	/**
	 * Eine Bestimmte Leihe entfernen
	 * @param l Leihe
	 */
	public void removeLeihe(LeiheDTO l){
		LeiheDAO.getInstance().delete(l);
	}
	
	/**
	 * Passwort �berpr�fen
	 * @param angeblichesPasswort Zu �berpr�fendes Passwort
	 * @return TRUE wenn korekt, sonst FALSE
	 */
	public boolean validierePasswort(MitgliedDTO m, String angeblichesPasswort){
		return m.getPasswort().equals(angeblichesPasswort);
		
	}
	

}
