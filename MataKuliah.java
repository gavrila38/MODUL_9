public class MataKuliah{
    
    //data field
    int tugas;
    int kuis;
    int UTS;
    int UAS;

    //constructor
    public MataKuliah(int tugas, int kuis, int UTS, int UAS){
        this.tugas = tugas;
        this.kuis = kuis;
        this.UTS = UTS;
        this.UAS = UAS;
    }

    
    public double hitungHasil(){
        return (tugas*kuis*UTS*UAS)/4.0;
    }
}