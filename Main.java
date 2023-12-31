import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_BLUE = "\u001B[34m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_WHITE = "\u001B[37m";

        String ANSI_BLACK_BACKGROUND = "\u001B[40m";
        String ANSI_RED_BACKGROUND = "\u001B[41m";
        String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
        String ANSI_BLUE_BACKGROUND = "\u001B[44m";
        String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
        String ANSI_CYAN_BACKGROUND = "\u001B[46m";
        String ANSI_WHITE_BACKGROUND = "\u001B[47m";

        Scanner sc = new Scanner(System.in);
        Scanner input = new Scanner(System.in); // ada 2 scanner karena ada menu master dan pilihan menu

        boolean isLoggedIn = false;
        boolean isLoggedAdmin = false;
        boolean isLoggedDosen = false;
        boolean isLoggedMahasiswa = false;

        String[][] userData = new String[][] {
                { "Admin", "Admin123" },
                { "Dosen", "Dosen456" },
                { "MahasiswaYonanda", "yonanda789", "2341760184", "082139631334", "Islam", "P", "05/05/2005" },
                { "MahasiswaDhynar", "dhynar789", "2341760109", "081238285591", "Islam", "P", "09/09/2004" },
                { "MahasiswaAfril", "afril789", "2341760067", "082245773455", "Islam", "L", "05/04/2005" },
                { "MahasiswaRama", "rama789", "2341760125", "085648275713", "Islam", "L", "11/11/2004" }};

        String[][] dataMahasiswa = new String[4][4];
        String[] jurusan = { "Teknologi Informasi", "Teknik Elektro", "Teknik Sipil" };
        String[][] prodi = {
                { "D4 Teknik Informatika", "D4 Sistem Informasi Bisnis", "D2 Pengembangan Piranti Lunak Situs" },
                { "D3 Teknik Telekomunikasi", "D3 Teknik Listrik", "D3 Teknik Elektronika",
                        "D4 Teknik Jaringan Telekomunikasi Digital", "D4 Sistem Kelistrikan", "D4 Teknik Elektronika" },
                { "D3 Teknik Sipil", "D3 Teknologi Pertambangan", "D3 Teknologi Konstruksi Jalan Jembatan Bangunan",
                        "D4 Manajemen Rekayasa Konstruksi", "D4 Teknologi Rekayasa Konstruksi Jalan Jembatan" } };

        int jumlahMataKuliah = 9; // Jumlah mata kuliah yang telah ditetapkan
        String[][] mataKuliah = new String[jumlahMataKuliah][4];
        boolean inginInputLagi = true;
        String inputData;
        String inputAgain;

        String[] matkul = { "CTPS", "PRAKDASPRO", "PAMB", "MTKDAS", "KTI", "DASPRO", "BING", "BINDO", "AGAMA" };
        String[] hari = new String[7];

        String username;
        String password;
        String previousUsername = " ";
        String previousPassword = " ";

        hari[0] = "Senin";
        hari[1] = "Selasa";
        hari[2] = "Rabu";
        hari[3] = "Kamis";
        hari[4] = "Jum'at";
        hari[5] = "Sabtu";
        hari[6] = "Minggu";
        String hasil = " ";

        boolean find = false;

        while (isLoggedIn == false) {
            System.out.println();
            System.out.println(ANSI_GREEN + "======================================");
            System.out.println(ANSI_GREEN + "|      SELAMAT DATANG DI SIAKAD!     |");
            System.out.println(ANSI_GREEN + "======================================" + ANSI_RESET);
            System.out.println("Silahkan Login Terlebih Dahulu!");
            System.out.print("Username      : ");
            username = sc.nextLine();
            System.out.print("Password      : ");
            password = sc.nextLine();

            for (int i = 0; i < userData.length; i++) {
                if (userData[0][0].equals(username) && userData[0][1].equals(password)) {
                    isLoggedAdmin = true;
                    isLoggedIn = true;
                    break;
                } else if (userData[1][0].equals(username) && userData[1][1].equals(password)) {
                    isLoggedDosen = true;
                    isLoggedIn = true;
                    break;
                } else if (userData[i][0].equals(username) && userData[i][1].equals(password)) {
                    isLoggedMahasiswa = true;
                    isLoggedIn = true;
                    break;
                }
            }
        }

        if (isLoggedIn) {
            outerLoopAdmin: while (true) {
                if (isLoggedAdmin) {
                    System.out.println(ANSI_YELLOW + "======================================");
                    System.out.println(ANSI_YELLOW + "|            HALAMAN ADMIN            |");
                    System.out.println(ANSI_YELLOW + "======================================" + ANSI_RESET);
                    System.out.println("Pilihan Menu : ");
                    System.out.println("|1| Input data mahasiswa");
                    System.out.println("|2| Input data mata kuliah");
                    System.out.println("|3| Pelaporan nilai mahasiswa");
                    System.out.println("|4| Keluar dari halaman admin\n");
                    System.out.print("Menu yang anda pilih : ");
                    int inputMenu = sc.nextInt();
                    sc.nextLine();

                    switch (inputMenu) {
                        case 1:
                            // input data mahasiswa
                            int i = 0;
                            do {
                                System.out.println("Masukkan data mahasiswa ke- " + (i + 1));
                                System.out.print("Nama      : ");
                                dataMahasiswa[i][0] = sc.nextLine();
                                System.out.print("NIM       : ");
                                dataMahasiswa[i][1] = sc.nextLine();

                                System.out.println("Jurusan   : ");
                                for (int j = 0; j < jurusan.length; j++) {
                                    System.out.println((j + 1) + ". " + jurusan[j]);
                                }
                                System.out.print("Jurusan yang dipilih : ");
                                int inputJurusan = sc.nextInt();
                                dataMahasiswa[i][2] = jurusan[--inputJurusan];
                                sc.nextLine();

                                System.out.println("Prodi     : ");
                                for (int j = 0; j < prodi[inputJurusan].length; j++) {
                                    System.out.println((j + 1) + ". " + prodi[inputJurusan][j]);
                                }
                                System.out.print("Prodi yang dipilih : ");
                                int inputProdi = sc.nextInt();
                                dataMahasiswa[i][3] = prodi[inputJurusan][--inputProdi];
                                sc.nextLine();
                                i++;
                                System.out.print("Apakah anda ingin melanjutkan input data mahasiswa lain? (y/t) : ");
                                inputData = sc.nextLine();

                            } while (inputData.equalsIgnoreCase("y"));
                            System.out.println("\nDaftar mahasiswa yang berhasil terinput:");
                            System.out.println(
                                    "========================================================================================================================");
                            System.out.printf("| %-4s | %-20s | %-12s | %-20s | %-48s |%n",
                                    "No", "Nama", "NIM", "Jurusan", "Program Studi");
                            System.out.println(
                                    "========================================================================================================================");

                            for (int j = 0; j < i; j++) {
                                if (dataMahasiswa[j][0] != null && !dataMahasiswa[j][0].isEmpty() &&
                                        dataMahasiswa[j][1] != null && !dataMahasiswa[j][1].isEmpty() &&
                                        dataMahasiswa[j][2] != null && !dataMahasiswa[j][2].isEmpty() &&
                                        dataMahasiswa[j][3] != null && !dataMahasiswa[j][3].isEmpty()) {
                                    System.out.printf("| %-4d | %-20s | %-12s | %-20s | %-48s |%n",
                                            (j + 1), dataMahasiswa[j][0], dataMahasiswa[j][1],
                                            dataMahasiswa[j][2], dataMahasiswa[j][3]);
                                }
                            }
                            System.out.println(
                                    "========================================================================================================================");
                            System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
                            inputAgain = sc.nextLine();
                            if (inputAgain.equalsIgnoreCase("t")) {
                                System.out.println("Anda telah log out");
                                break outerLoopAdmin; // Break out of the outer loop to logout
                            }
                            break;

                        case 2:
                            // input data mata kuliah
                            while (inginInputLagi) {
                                for (int k = 0; k < mataKuliah.length; k++) {
                                    System.out.println("Masukkan data mata kuliah ke-" + (k + 1));
                                    System.out.print("Masukkan Nama Mata Kuliah : ");
                                    String namaMataKuliah = sc.nextLine();
                                    if (namaMataKuliah.isEmpty()) {
                                        break;
                                    }
                                    mataKuliah[k][0] = namaMataKuliah;

                                    System.out.print("Masukkan Semester         : ");
                                    mataKuliah[k][1] = sc.nextLine();

                                    System.out.print("Masukkan SKS Mata Kuliah  : ");
                                    mataKuliah[k][2] = sc.nextLine();

                                    System.out.print("Masukkan Dosen Pengampu   : ");
                                    mataKuliah[k][3] = sc.nextLine();

                                    System.out.println();

                                    if (k == jumlahMataKuliah - 1) {
                                        System.out.println("Jumlah mata kuliah sudah mencapai batas maksimum (9).");
                                        inginInputLagi = false;
                                        break;
                                    }

                                    System.out.print("Apakah anda ingin menginputkan mata kuliah lagi? (y/t): ");
                                    String jawaban = sc.nextLine();
                                    if (!jawaban.equalsIgnoreCase("y")) {
                                        inginInputLagi = false;
                                        break;
                                    }
                                }
                            }

                            System.out.println("\nData mata kuliah yang telah diinput");
                            System.out.println(
                                    "===========================================================================================");
                            System.out.println(
                                    "| No |         Nama Mata Kuliah        |  Semester | SKS |          Dosen Pengampu        |");
                            System.out.println(
                                    "===========================================================================================");
                            boolean adaData = false;
                            for (int l = 0; l < mataKuliah.length; l++) {
                                if (mataKuliah[l][0] != null) {
                                    adaData = true;
                                    System.out.printf("| %-2d | %-31s | %-9s | %-3s | %-30s |%n", l + 1,
                                            mataKuliah[l][0], (mataKuliah[l][1] != null ? mataKuliah[l][1] : "-"),
                                            (mataKuliah[l][2] != null ? mataKuliah[l][2] : "-"),
                                            (mataKuliah[l][3] != null ? mataKuliah[l][3] : "-"));
                                } else {
                                    break;
                                }
                            }
                            System.out.println(
                                    "===========================================================================================");

                            if (!adaData) {
                                System.out.println("Belum ada data mata kuliah yang diinput.");
                            }
                            System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
                            inputAgain = sc.nextLine();
                            if (inputAgain.equalsIgnoreCase("t")) {
                                System.out.println("Anda telah log out");
                                break outerLoopAdmin; // Break out of the outer loop to logout
                            }
                            break;

                        case 3:
                            // pelaporan nilai mahasiswa
                            Scanner scanner = new Scanner(System.in);
                            boolean inputLagi = true;
                            do {
                                // Input data mahasiswa
                                String namaMahasiswa, nim, ttl;
                                System.out.print("Masukkan Nama Mahasiswa: ");
                                namaMahasiswa = scanner.next();
                                System.out.print("Masukkan NIM Mahasiswa: ");
                                nim = scanner.next();
                                System.out.print("Masukkan Tempat, Tanggal Lahir: ");
                                ttl = scanner.next();

                                // Input jumlah mata kuliah
                                System.out.print("Masukkan Jumlah Mata Kuliah: ");
                                int jmlMataKuliah = scanner.nextInt();
                                System.out.println("====================================");

                                String[] namaMatkul = new String[jmlMataKuliah];
                                int[] sksMatkul = new int[jmlMataKuliah];
                                int[] jamMatkul = new int[jumlahMataKuliah];
                                String[] nilaiMatkulHuruf = new String[jmlMataKuliah];
                                double[] nilaiMatkulAngka = new double[jmlMataKuliah];

                                // Input nilai mata kuliah
                                for (int k = 0; k < jmlMataKuliah; k++) {
                                    scanner.nextLine();
                                    System.out.print("\nMasukkan Nama Mata Kuliah ke-" + (k + 1) + ": ");
                                    namaMatkul[k] = scanner.nextLine();
                                    System.out.print("Masukkan SKS Mata Kuliah ke-" + (k + 1) + ": ");
                                    sksMatkul[k] = scanner.nextInt();
                                    System.out.print("Masukkan Jam Mata Kuliah ke-" + (k + 1) + ": ");
                                    jamMatkul[k] = scanner.nextInt();
                                    System.out.print("Masukkan Nilai Mata Kuliah ke-" + (k + 1) + ": ");
                                    nilaiMatkulHuruf[k] = scanner.next().toUpperCase(); // Konversi ke huruf besar

                                    // Konversi nilai huruf ke angka
                                    switch (nilaiMatkulHuruf[k]) {
                                        case "A":
                                            nilaiMatkulAngka[k] = 4.0;
                                            break;
                                        case "B+":
                                            nilaiMatkulAngka[k] = 3.5;
                                            break;
                                        case "B":
                                            nilaiMatkulAngka[k] = 3.0;
                                            break;
                                        case "C+":
                                            nilaiMatkulAngka[k] = 2.5;
                                            break;
                                        case "C":
                                            nilaiMatkulAngka[k] = 2.0;
                                            break;
                                        default:
                                            nilaiMatkulAngka[k] = 0.0;
                                    }
                                }

                                // Cetak KHS
                                double totalNilai = 0;
                                int totalSKS = 0;

                                System.out.println("====================================================");
                                System.out.println("|             Kartu Hasil Studi (KHS)              |");
                                System.out.println("====================================================");
                                System.out.println("Nama    : " + namaMahasiswa);
                                System.out.println("NIM     : " + nim);
                                System.out.println("TTL     : " + ttl);
                                System.out.println("=======================================");
                                System.out.printf("| %-15s | %-3s | %-3s | %-5s |%n", "Mata Kuliah", "SKS", "Jam",
                                        "Nilai");
                                System.out.println("=======================================");

                                for (int k = 0; k < namaMatkul.length; k++) {
                                    System.out.printf("| %-15s | %-3d | %-3d | %-5s |%n", namaMatkul[k], sksMatkul[k],
                                            jamMatkul[k],
                                            nilaiMatkulHuruf[k]);
                                            double nilaiAngka = nilaiMatkulAngka[k];
                                    totalNilai += nilaiMatkulAngka[k] * sksMatkul[k];
                                    totalSKS += sksMatkul[k];
                                }

                                double ipk = totalNilai / totalSKS;
                                System.out.println("=======================================");
                                System.out.printf("| %-15s | %-3s | %-3s | %-4.3f |%n", "IPK", "", "", ipk);
                                System.out.println("=======================================");
                                
                                System.out.println();

                                System.out.print("Apakah Anda ingin menginput KHS lain? (y/t): ");
                                String pilihan = scanner.next();
                                inputLagi = pilihan.equalsIgnoreCase("y");

                            } while (inputLagi);
                            System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
                            inputAgain = sc.nextLine();
                            if (inputAgain.equalsIgnoreCase("t")) {
                                System.out.println("Anda telah log out");
                                break outerLoopAdmin; // Break out of the outer loop to logout
                            }
                            break;

                        case 4:
                            // keluar dari halaman admin
                            System.out.println(ANSI_RED + "Anda telah keluar dari halaman admin" + ANSI_RESET);
                            break outerLoopAdmin;

                        default:
                            break;
                    }

                } else if (isLoggedDosen) {
                    // input nilai mahasiswa
                    outerLoopDosen: while (true) {
                        System.out.println(ANSI_YELLOW + "======================================");
                        System.out.println(ANSI_YELLOW + "|            HALAMAN DOSEN            |");
                        System.out.println(ANSI_YELLOW + "======================================" + ANSI_RESET);
                        System.out.println("Pilihan Menu : ");
                        System.out.println("|1| Input nilai mahasiswa");
                        System.out.println("|2| Keluar dari halaman dosen");
                        System.out.print("Menu yang anda pilih : ");
                        int inputMenu = sc.nextInt();

                        switch (inputMenu) {
                            case 1:
                                do {
                                    String[] finded = new String[1];
                                    System.out.print("Masukkan matkul yang akan diinputkan nilainya : ");
                                    String inpmatkul = input.nextLine();
                                    boolean ditemukan = false;

                                    for (int i = 0; i < matkul.length; i++) {
                                        if (matkul[i].equalsIgnoreCase(inpmatkul)) {
                                            ditemukan = true;
                                            finded[0] = matkul[i];
                                            break;
                                        }
                                    }

                                    if (ditemukan) {
                                        System.out
                                                .println("Matkul yang ingin diinputkan nilai ditemukan: " + finded[0]);
                                        System.out.println("===============================================");

                                        int jumlahMahasiswa;
                                        do {
                                            System.out.print("Masukkan jumlah mahasiswa yang ingin diinput nilai: ");
                                            while (!input.hasNextInt()) {
                                                System.out
                                                        .println("Input harus berupa angka. Silakan masukkan kembali.");
                                                input.next();
                                            }
                                            jumlahMahasiswa = input.nextInt();
                                        } while (jumlahMahasiswa <= 0);

                                        int[][] inputNilai = new int[jumlahMahasiswa][2];
                                        String[] namaMahasiswa = new String[jumlahMahasiswa];

                                        for (int i = 0; i < inputNilai.length; i++) {
                                            System.out.println("Menginput nilai untuk mahasiswa ke-" + (i + 1));
                                            input.nextLine(); // Clear the buffer
                                            System.out.print("Nama mahasiswa: ");
                                            namaMahasiswa[i] = input.nextLine();
                                            System.out.print("Nilai UTS: ");
                                            inputNilai[i][0] = input.nextInt();
                                            System.out.print("Nilai UAS: ");
                                            inputNilai[i][1] = input.nextInt();
                                        }

                                        // Menampilkan hasil input dalam bentuk tabel
                                        System.out.println(
                                                "============================================================================");
                                        System.out.println(finded[0]);
                                        System.out.println(
                                                "Nama Mahasiswa     \t\t\t| Nilai UTS | Nilai UAS | Rata-rata ");
                                        System.out.println(
                                                "============================================================================");
                                        for (int i = 0; i < inputNilai.length; i++) {
                                            double rataRata = (inputNilai[i][0] + inputNilai[i][1]) / 2.0;
                                            System.out.printf("%-39s | %-9d | %-9d | %-8.2f\n", namaMahasiswa[i],
                                                    inputNilai[i][0],
                                                    inputNilai[i][1], rataRata);
                                        }
                                        System.out.println();

                                    } else {
                                        System.out.println("Matkul tidak ditemukan");
                                        break;
                                    }
                                    input.nextLine();
                                    System.out
                                            .print("Apakah Anda ingin menginput nilai untuk mata kuliah lain? (y/t): ");
                                    inputAgain = input.nextLine();

                                } while (inputAgain.equalsIgnoreCase("y"));
                                System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
                                inputAgain = sc.next();
                                if (inputAgain.equalsIgnoreCase("t")) {
                                    System.out.println("Anda telah log out");
                                    isLoggedDosen = false;
                                    break outerLoopDosen;
                                }
                                break;

                            case 2:
                                // keluar dari halaman dosen
                                System.out.println("Anda telah log out");
                                isLoggedDosen = false;
                                break outerLoopDosen;

                            default:
                                break;
                        }
                    }

                } else if (isLoggedMahasiswa) {
                    outerLoopMahasiswa: while (true) {
                        System.out.println(ANSI_YELLOW + "======================================");
                        System.out.println(ANSI_YELLOW + "|          HALAMAN MAHASISWA         |");
                        System.out.println(ANSI_YELLOW + "======================================" + ANSI_RESET);
                        System.out.println("Pilihan Menu : ");
                        System.out.println("|1| Update data mahasiswa");
                        System.out.println("|2| Cetak KHS dan Nilai");
                        System.out.println("|3| Searching Matkul");
                        System.out.println("|4| Keluar dari halaman mahasiswa\n");
                        System.out.print("Menu yang anda pilih : ");
                        int inputMenu = sc.nextInt();

                        switch (inputMenu) {
                            case 1:
                                // update data mahasiswa
                                // Menampilkan pilihan pengguna yang data-nya bisa diubah
                                System.out.println("Pilih pengguna mahasiswa untuk memperbarui data:");
                                for (int i = 2; i < userData.length; i++) {
                                    System.out.println((i - 1) + " " + userData[i][0]);
                                }
                                System.out.print("Masukkan angka pilihan: ");
                                int pilihan = input.nextInt();
                                // Memperbarui data pengguna
                                String[] selectedUser;
                                if (pilihan > 0 && pilihan <= userData.length) {
                                    selectedUser = userData[pilihan + 1];
                                    System.out.println("\nData yang tersedia untuk pengguna " + selectedUser[0] + ":");
                                    System.out.println(
                                            "=========================================================================================================================================================");
                                    System.out.printf("| %-18s | %-20s | %-20s | %-20s | %-10s | %-10s | %-10s |\n",
                                            "Username", "Password", "No Telepon", "Agama", "Jenis Kelamin",
                                            "Tanggal Lahir");
                                    System.out.println(
                                            "=========================================================================================================================================================");
                                    System.out.printf("| %-18s | %-20s | %-20s | %-20s | %-10s | %-10s | %-10s |\n",
                                            selectedUser[0], selectedUser[1], selectedUser[2], selectedUser[3],
                                            selectedUser[4], selectedUser[5], selectedUser[6], selectedUser[7]);
                                    System.out.println(
                                            "================================================================================================================================================");

                                    System.out.print("\nMasukkan angka data yang ingin diubah: ");
                                    int dataChoice = input.nextInt();

                                    if (dataChoice > 0 && dataChoice < selectedUser.length) {
                                        input.nextLine();
                                        System.out.println("Masukkan data baru : ");
                                        String newData = input.next();
                                        selectedUser[dataChoice] = newData;
                                    } else {
                                        System.out.println("Pilihan tidak valid");
                                    }

                                    // menampilkan data pengguna 
                                    System.out.println("\nData Pengguna Baru:");
                                    System.out.println("=========================================================================================================================================================");
                                    System.out.printf("| %-18s | %-20s | %-20s | %-20s | %-15s | %-10s | %-10s | %-10s |\n" , "Username", "Password", "NIM", "No Telepon", "Agama", "Jenis Kelamin", "Tanggal Lahir");
                                    System.out.println("=========================================================================================================================================================");
                                    for (int i = 0; i < userData.length; i++) {
                                        System.out.printf("| %-18s | %-20s | %-20s | %-20s | %-15s | %-10s | %-10s | %-10s |\n" , userData[i][0], userData[i][1], userData[i][2], userData[i][3], userData[i][4], userData[i][5], userData[i][6], userData[i][7]);
                                    }
                                    System.out.println("=========================================================================================================================================================");
                                    break;
                                }

                            case 2:
                                // ini cetak khs dan nilai

                                break;

                            case 3:
                                // ini searching matkul
                                System.out.println("Matkul anda adalah sebagai berikut : ");
                                for (int i = 0; i < matkul.length; i++) {
                                    System.out.println(matkul[i]);
                                }

                                System.out.print("Masukkan matkul yang ingin dicari : ");
                                String inputmatkul = input.next();
                                for (int i = 0; i < matkul.length; i++) {
                                    if (matkul[i].equals(inputmatkul)) {
                                        find = true;
                                        hasil = matkul[i] = hari[i];
                                        break;
                                    }
                                }

                                if (find) {
                                    System.out.println("Matkul yang anda cari ada di hari: " + hasil);
                                } else {
                                    System.out.println("Matkul tidak ditemukan");
                                }

                                System.out.print("Apakah anda ingin memilih menu lain? (y/t) = ");
                                char ulang = sc.next().charAt(0);
                                sc.nextLine();
                                if (ulang == 't') {
                                    System.out.println("Anda telah log out");
                                    break;
                                }
                            case 4:
                                // keluar dari halaman mahasiswa
                                System.out.println("Anda telah log out");
                                isLoggedMahasiswa = false;
                                break outerLoopMahasiswa;

                            default:
                                break;
                        }
                    }
                }
            }
        } else

        {
            System.out.println("");
        }
    }
}
