package save;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class SaveTasksImpl implements SaveTask {

    private final String filePath = "taskslist.xml";

    @Override
    public <T>T fromXmlToObject(T t) {
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (T) un.unmarshal(new File(filePath));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }

    // сохраняем объект в XML файл
    @Override
    public <T> void convertObjectToXml(T object) {
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(object, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}