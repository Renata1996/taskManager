package save;

/**
 * Created by Рената on 01.12.2016.
 */
public interface SaveTask {
    <T> T fromXmlToObject(T object);
    <T> void convertObjectToXml(T object);
}
