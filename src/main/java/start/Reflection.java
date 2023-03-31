package start;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Reflection{
	/**
	 *  functia retrieveField returneaza o lista de String-uri cu
	 *  fiecare camp instanta al obectului trimis ca parametru
	 * @param object
	 * @return
	 */
	public static ArrayList<String> retrieveField(Object object) {
		ArrayList<String> fields=new ArrayList<String>();
		int i=0;
		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			Object value;
			try {
				value = field.get(object);
				if(!field.getName().equals("id")) {
					fields.add(field.getName());
					i++;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return fields;
	}

	/**
	 *   functia addToStatement adauga in statement-ul trimis ca parametru
	 *   toate campurile din obiectul object
	 * @param statement
	 * @param object
	 */
	public static void addToStatement(PreparedStatement statement, Object object) {
		int i=1;
		for (Field field : object.getClass().getDeclaredFields()) {
			//statement.setInt(1, id);
			field.setAccessible(true);
			Object value;
			try {
				value = field.get(object);
				if(!field.getName().equals("id")) {
					if (value instanceof String)
						statement.setString(i, (String) value);
					if (value instanceof Integer)
						statement.setInt(i, (Integer) value);
					if (value instanceof Double)
						statement.setDouble(i, (Double) value);
					i++;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}



