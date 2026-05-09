public class Probstat extends MataKuliah{

    //data field
    double bobotTugas = 0.4;
    double bobotKuis = 0.1;
    double bobotUTS = 0.2;
    double bobotUAS = 0.3;
    
    //constructor
    public Probstat(int tugas, int kuis, int uts, int uas){
        super(tugas, kuis, uts, uas);
    }
    
    @Override
    public double hitungHasil(){
        return ((super.tugas*bobotTugas)+(super.kuis*bobotKuis)+(super.UTS*bobotUTS)+(super.UAS*bobotUAS));
    }
}