package clases;

import soporte.*;

import java.io.Serializable;

public class Catalogo implements Serializable {
    private TSBArrayList series;

    public Catalogo(){
        series = new TSBArrayList();
        series.add(new Serie("Friends",1994,10));
        series.add(new Serie("ER",1994,15));
        series.add(new Serie("Moderm Family",2008,11));
        series.add(new Serie("Moderm Family",2008,11));
        series.add(new Serie("Moderm Family",2008,11));
        series.add(new Serie("Moderm Family",2008,11));
        series.add(new Serie("Moderm Family",2008,11));
        series.add(new Serie("Moderm Family",2008,11));
        series.add(new Serie("Moderm Family",1400,11));
        series.add(new Serie("Moderm Family",1400,11));
        series.add(new Serie("Moderm Family",1400,11));
        series.add(new Serie("Moderm Family",1400,11));
        series.add(new Serie("Moderm Family",1400,11));
        series.add(new Serie("Moderm Family",1400,11));
        series.add(new Serie("Moderm Family",1400,11));
        series.add(new Serie("Moderm Family",1400,11));
    }


    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder("Catalogo");
        for (Object o: series
        ) {
            Serie s = (Serie)o;
            texto.append(s.toString());

        }
        return texto.toString();
    }
    public int descargarPorEstreno(int estreno){
        TSBArrayList descargar = new TSBArrayList();
        for (Object o: series
        ) {
            Serie s = (Serie) o;
            if(s.getEstreno() ==estreno)
                descargar.add(s);
        }
        TSBArrayListWriter listWriter = new TSBArrayListWriter("Estrenos" + estreno + ".dat");
        try{
            listWriter.write(descargar);
            return descargar.size();
        }
        catch (TSBArrayListIOException e){
            System.out.println(e.getMessage());
            return -1;
        }

    }
    //este metodo me permite guardar en un archivo un arraylist
    public int descargarCompleto(){
        TSBArrayList descargar = new TSBArrayList();
        for (Object o :series
        ) {
            Serie s = (Serie) o;
            descargar.add(s);
        }
        TSBArrayListWriter listWriter = new TSBArrayListWriter("ventas.dat");
        try{
            listWriter.write(descargar);
            return descargar.size();
        }
        catch (TSBArrayListIOException e){
            System.out.println(e.getMessage());
            return -1;
        }
    }


    public String buscarDescarga(int year){
        TSBArrayListReader listReader = new TSBArrayListReader("Estrenos"+year+".dat");
        try{
            TSBArrayList descarga = (TSBArrayList) listReader.read();
            return descarga.toString();
        }
        catch (TSBArrayListIOException e){
            return e.getMessage();
        }
    }
