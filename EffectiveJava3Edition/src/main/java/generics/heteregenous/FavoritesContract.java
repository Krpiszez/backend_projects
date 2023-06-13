package generics.heteregenous;

// API 
public interface FavoritesContract {
	
	<T> void putFavorite(Class<T> type, T instance);
    <T> T getFavorite(Class<T> type);

}
