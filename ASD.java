public class ASD extends MataKuliah{

    //data field
    double bobotTugas = 0.3;
    double bobotKuis = 0.1;
    double bobotUTS = 0.2;
    double bobotUAS = 0.4;

    //constructor
    public ASD(int tugas, int kuis, int UTS, int UAS){
        super(tugas, kuis, UTS, UAS);
    }

    @Override
    public double hitungHasil(){
        return ((super.tugas*bobotTugas)+(super.kuis*bobotKuis)+(super.UTS*bobotUTS)+(super.UAS*bobotUAS));
    }
}