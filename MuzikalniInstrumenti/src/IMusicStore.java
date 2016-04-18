
public interface IMusicStore {
	void addMusicInstrument(MusicInstrument instrument, Integer count);
	 void sellInstrument(MusicInstrument instrument, Integer count);
	 void listAvailableItems();
	 void listItemsByName();
	 void listIntemsByType();
	 void listItemsByPrice(String orderBy);
	 public void sortItemsByNumbersSold();
	 public void showMostSoldItem(String mostLeastSold);
	 
}
