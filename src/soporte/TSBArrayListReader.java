package soporte;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TSBArrayListReader {
    private String archivo = "lista.dat";

    public TSBArrayListReader(){}

    public TSBArrayListReader(String nombre){
        archivo = nombre;
    }

    public TSBArrayList read() throws TSBArrayListIOException
    {
        TSBArrayList al = null;
        try{
            FileInputStream istream = new FileInputStream(archivo);//"C:\\Users\\usuario\\Desktop\\TSBç\\ArchivosCreadosJava\\"
            ObjectInputStream p = new ObjectInputStream(istream);

            al = (TSBArrayList) p.readObject();

            p.close();
            istream.close();
        }
        catch (Exception e){
            throw new TSBArrayListIOException("No se pudo recuperar la lista");
        }
        return al;
    }
}
