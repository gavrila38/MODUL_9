import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;


public class Program extends Frame{

    Label judul, tugas, kuis, uts, uas, hasil;
    Checkbox asd, pemlan, matkomlan, probstat;
    Button hitungButton, showButton;
    TextField tugasInput, kuisInput, utsInput, uasInput, hasilInput;
    CheckboxGroup cbg;

    public Program(){
        this.setLayout(null);

        judul = new Label("Hitung Nilai Akhir");
        judul.setFont(new Font("Arial",1,15));
        judul.setBounds(115,30,170,20);

        cbg = new CheckboxGroup();
        asd = new Checkbox("asd",cbg,false);
        asd.setBounds(20,65,90,20);
        pemlan = new Checkbox("pemlan",cbg,false);
        pemlan.setBounds(110,65,90,20);
        matkomlan = new Checkbox("matkomlan",cbg,false);
        matkomlan.setBounds(200,65,90,20);
        probstat = new Checkbox("probstat",cbg,false);
        probstat.setBounds(290,65,90,20);


        //Memmbuat komponen yang akan diinput user
        tugas = new Label("Tugas : ");
        tugas.setBounds(120,100,70,20);

        tugasInput = new TextField();
        tugasInput.setBounds(220,100,60,20);

        kuis = new Label("Kuis : ");
        kuis.setBounds(120,125,70,20);

        kuisInput = new TextField();
        kuisInput.setBounds(220,125,60,20);

        uts = new Label("UTS : ");
        uts.setBounds(120,150,70,20);

        utsInput = new TextField();
        utsInput.setBounds(220,150,60,20);

        uas = new Label("UAS : ");
        uas.setBounds(120,175,70,20);

        uasInput = new TextField();
        uasInput.setBounds(220,175,60,20);

        hasil = new Label("Hasil : ");
        hasil.setBounds(120,200,70,20);

        hasilInput = new TextField("Belum ada nilai");
        hasilInput.setBounds(220,200,60,20);


        //Button untuk menghitung nilai matakuliah yang dipilih -------------------------
        hitungButton = new Button("Hitung");
        hitungButton.setBounds(150,250,100,20);

 
        TextArea txt = new TextArea();
        txt.setBounds(65,300,270,200);


        //Button untuk menampilkan semuanya------------------------------
        Button showAllButton = new Button("Tampilkan nilai semua matkul");
        showAllButton.setBounds(50,550,300,20);
       

        //Menambahkan semua komponen
        this.add(judul);
        this.add(asd);
        this.add(pemlan);
        this.add(matkomlan);
        this.add(probstat);
        this.add(tugas);
        this.add(tugasInput);
        this.add(kuis);
        this.add(kuisInput);
        this.add(uts);
        this.add(utsInput);
        this.add(uas);
        this.add(uasInput);
        this.add(hasil);
        this.add(hasilInput);
        this.add(hitungButton);

        this.add(txt);
        this.add(showAllButton);


        //Mengatasi bug dibagian text area maka menggunakan HashMap
        Map<String,Double> totalHasil = new HashMap<>();

        //Memastikan agar ketika pindah checkbox semua nilai textField kosong
        asd.addItemListener(a ->{
            tugasInput.setText("");
            kuisInput.setText("");
            utsInput.setText("");
            uasInput.setText("");
            hasilInput.setText("Belum ada nilai");
        });
        pemlan.addItemListener(a ->{
            tugasInput.setText("");
            kuisInput.setText("");
            utsInput.setText("");
            uasInput.setText("");
            hasilInput.setText("Belum ada nilai");
        });
        matkomlan.addItemListener(a ->{
            tugasInput.setText("");
            kuisInput.setText("");
            utsInput.setText("");
            uasInput.setText("");
            hasilInput.setText("Belum ada nilai");
        });
        probstat.addItemListener(a ->{
            tugasInput.setText("");
            kuisInput.setText("");
            utsInput.setText("");
            uasInput.setText("");
            hasilInput.setText("Belum ada nilai");
        });

        hitungButton.addActionListener(e ->{
            //Tambahkan action event --------------------------
            if(asd.getState()){
                System.out.println("pilihan ASD");

                    int nilaiTugas = Integer.parseInt(tugasInput.getText().trim());
                    int nilaiKuis = Integer.parseInt(kuisInput.getText().trim());
                    int nilaiUTS = Integer.parseInt(utsInput.getText().trim());
                    int nilaiUAS = Integer.parseInt(uasInput.getText().trim());
            
                MataKuliah asd = new ASD(nilaiTugas, nilaiKuis, nilaiUTS, nilaiUAS);
                hasilInput.setText(String.valueOf(asd.hitungHasil()));

                //Masukkan nilai yang sudah dihitung ke dalam HashMap
                totalHasil.put("ASD " ,asd.hitungHasil());
         
            }

            else if(pemlan.getState()){
                System.out.println("pilihan pemlan"); 
               
                    int nilaiTugas = Integer.parseInt(tugasInput.getText().trim());
                    int nilaiKuis = Integer.parseInt(kuisInput.getText().trim());
                    int nilaiUTS = Integer.parseInt(utsInput.getText().trim());
                    int nilaiUAS = Integer.parseInt(uasInput.getText().trim());
            
                    MataKuliah pemlan = new Pemlan(nilaiTugas, nilaiKuis, nilaiUTS, nilaiUAS);
                    hasilInput.setText(String.valueOf(pemlan.hitungHasil()));
                    totalHasil.put("Pemlan", pemlan.hitungHasil());
  
            }
            else if(matkomlan.getState()){
                System.out.println("pilihan matkomlan");
               
                    int nilaiTugas = Integer.parseInt(tugasInput.getText().trim());
                    int nilaiKuis = Integer.parseInt(kuisInput.getText().trim());
                    int nilaiUTS = Integer.parseInt(utsInput.getText().trim());
                    int nilaiUAS = Integer.parseInt(uasInput.getText().trim());
                    
                    MataKuliah matkomlan = new Matkomlan(nilaiTugas, nilaiKuis, nilaiUTS, nilaiUAS);
                    hasilInput.setText(String.valueOf(matkomlan.hitungHasil()));
                    totalHasil.put("Matkomlan", matkomlan.hitungHasil());
   
            }
            else if(probstat.getState()){
                System.out.println("pilihan probstat");

                    int nilaiTugas = Integer.parseInt(tugasInput.getText().trim());
                    int nilaiKuis = Integer.parseInt(kuisInput.getText().trim());
                    int nilaiUTS = Integer.parseInt(utsInput.getText().trim());
                    int nilaiUAS = Integer.parseInt(uasInput.getText().trim());
                    
                    MataKuliah probstat = new Probstat(nilaiTugas, nilaiKuis, nilaiUTS, nilaiUAS);
                    hasilInput.setText(String.valueOf(probstat.hitungHasil()));
                    totalHasil.put("Probstat", probstat.hitungHasil());
 
            }

    });

     showAllButton.addActionListener(q -> {

        //Otomatis mengoverride semua text sebelumya
        txt.setText("HASIL NILAI SEMUA MATAKULIAH\n");

                //Tampilkan semua nilai dalam HashMap dengan looping
                for(String key : totalHasil.keySet()){
                    txt.append(key + " : " + totalHasil.get(key) + "\n");

                }
            });
    }


    public static void main(String[] args){
        Program frame = new Program();
        frame.setSize(400,600);
        frame.setVisible(true);
        //Agar window bisa diclose
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent w){
                System.exit(0);
            }
        });
    }
}

