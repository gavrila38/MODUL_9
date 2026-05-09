public class Pemlan extends MataKuliah{
    
    //data field
    double bobotTugas = 0.20;
    double bobotKuis = 0.10;
    double bobotUTS = 0.20;
    double bobotUAS = 0.50;

    //constructor
    public Pemlan(int tugas, int kuis, int uts, int uas){
        super(tugas, kuis, uts, uas);
    }

    @Override
    public double hitungHasil(){
        return ((super.tugas*bobotTugas)+(super.kuis*bobotKuis)+(super.UTS*bobotUTS)+(super.UAS*bobotUAS));
    }

}