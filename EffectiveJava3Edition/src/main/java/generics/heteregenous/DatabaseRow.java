package generics.heteregenous;

import java.util.HashMap;
import java.util.Map;

public class DatabaseRow {

	private final Map<Column<?>, Object> columns = new HashMap<>();

	public <T> void putColumn(Column<T> type, T instance) 
	{
		if (type == null)
			throw new NullPointerException("Type is null");

		// Achieving runtime type safety with a dynamic cast
		// Same trick can be found in the following implementations
		// checkedSet, checkedList, checkedMap, and so forth.
		columns.put(type, instance.getClass().cast(instance));

	}

	public <T> T getColumn(Column<T> type) {

		return type.cast(columns.get(type));
	}

}