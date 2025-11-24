package Practica_6.Biblioteca;

import java.io.Serializable;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
public class Biblioteca extends JFrame implements Serializable {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Autor> autores;
    private ArrayList<Prestamo> prestamos;
    private Horario horario;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Biblioteca frame = new Biblioteca();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Biblioteca() {
        Biblioteca loaded = cargar();
        if (loaded != null) {
            this.nombre = loaded.nombre;
            this.libros = loaded.libros;
            this.autores = loaded.autores;
            this.prestamos = loaded.prestamos;
            this.horario = loaded.horario;
            JOptionPane.showMessageDialog(null, "Biblioteca cargada desde archivo.");
        } else {
            this.nombre = "Biblioteca UMSA";
            this.libros = new ArrayList<>();
            this.autores = new ArrayList<>();
            this.prestamos = new ArrayList<>();
            this.horario = new Horario("Lunes a Viernes", "08:00", "18:00");
            JOptionPane.showMessageDialog(null, "No se encontró archivo. Creando nueva biblioteca.");
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelHeader = new JPanel();
        panelHeader.setBackground(new Color(173, 216, 230));
        panelHeader.setBounds(0, 0, 484, 50);
        contentPane.add(panelHeader);
        panelHeader.setLayout(null);

        JLabel lblTitulo = new JLabel("Gestión de Biblioteca");
        lblTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblTitulo.setBounds(150, 10, 200, 30);
        panelHeader.add(lblTitulo);
        
                JLabel lblImagen = new JLabel("");
                lblImagen.setBounds(284, 11, 200, 50);
                panelHeader.add(lblImagen);
                lblImagen.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\ALAN 2025\\IMAGENES\\Imagenes_para_informatica\\logo_biblioteca_1.png"));

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(240, 240, 240));
        panelBotones.setBounds(0, 50, 150, 311);
        contentPane.add(panelBotones);
        panelBotones.setLayout(null);

        JButton btnAgregarLibro = new JButton("Agregar Libro");
        btnAgregarLibro.setBounds(10, 10, 120, 25);
        btnAgregarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarLibroUI();
            }
        });
        panelBotones.add(btnAgregarLibro);

        JButton btnAgregarAutor = new JButton("Agregar Autor");
        btnAgregarAutor.setBounds(10, 45, 120, 25);
        btnAgregarAutor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarAutorUI();
            }
        });
        panelBotones.add(btnAgregarAutor);

        JButton btnPrestarLibro = new JButton("Prestar Libro");
        btnPrestarLibro.setBounds(10, 80, 120, 25);
        btnPrestarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prestarLibroUI();
            }
        });
        panelBotones.add(btnPrestarLibro);

        JButton btnMostrarEstado = new JButton("Mostrar Estado");
        btnMostrarEstado.setBounds(10, 115, 120, 25);
        btnMostrarEstado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarEstadoUI();
            }
        });
        panelBotones.add(btnMostrarEstado);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(10, 150, 120, 25);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardar();
                JOptionPane.showMessageDialog(null, "Biblioteca guardada.");
            }
        });
        panelBotones.add(btnGuardar);

        JButton btnCargar = new JButton("Cargar");
        btnCargar.setBounds(10, 185, 120, 25);
        btnCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Biblioteca loaded = cargar();
                if (loaded != null) {
                    nombre = loaded.nombre;
                    libros = loaded.libros;
                    autores = loaded.autores;
                    prestamos = loaded.prestamos;
                    horario = loaded.horario;
                    JOptionPane.showMessageDialog(null, "Biblioteca cargada.");
                    mostrarEstadoUI();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo cargar.");
                }
            }
        });
        panelBotones.add(btnCargar);

        JButton btnCerrarBiblio = new JButton("Cerrar Biblio");
        btnCerrarBiblio.setBounds(10, 220, 120, 25);
        btnCerrarBiblio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cerrarBiblioteca();
                JOptionPane.showMessageDialog(null, "Préstamos eliminados.");
                mostrarEstadoUI();
            }
        });
        panelBotones.add(btnCerrarBiblio);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(150, 50, 334, 250);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setEditable(false);
    }

    private void agregarLibroUI() {
        String titulo = JOptionPane.showInputDialog("Título del libro:");
        if (titulo == null) return;
        String isbn = JOptionPane.showInputDialog("ISBN:");
        if (isbn == null) return;
        String numPagStr = JOptionPane.showInputDialog("Número de páginas:");
        if (numPagStr == null) return;
        int numPag = Integer.parseInt(numPagStr);
        String[] contenidos = new String[numPag];
        for (int i = 0; i < numPag; i++) {
            contenidos[i] = "Contenido página " + (i + 1);
        }
        Libro libro = new Libro(titulo, isbn, contenidos);
        libros.add(libro);
        JOptionPane.showMessageDialog(null, "Libro agregado.");
    }

    private void agregarAutorUI() {
        String nombre = JOptionPane.showInputDialog("Nombre del autor:");
        if (nombre == null) return;
        String nacionalidad = JOptionPane.showInputDialog("Nacionalidad:");
        if (nacionalidad == null) return;
        Autor autor = new Autor(nombre, nacionalidad);
        autores.add(autor);
        JOptionPane.showMessageDialog(null, "Autor agregado.");
    }

    private void prestarLibroUI() {
        String codEst = JOptionPane.showInputDialog("Código del estudiante:");
        if (codEst == null) return;
        String nomEst = JOptionPane.showInputDialog("Nombre del estudiante:");
        if (nomEst == null) return;
        Estudiante est = new Estudiante(codEst, nomEst);
        String titLib = JOptionPane.showInputDialog("Título del libro:");
        if (titLib == null) return;
        Libro libro = null;
        for (Libro l : libros) {
            if (l.getTitulo().equals(titLib)) {
                libro = l;
                break;
            }
        }
        if (libro != null) {
            String fPrestamo = "2025-11-10";
            String fDevolucion = "2025-11-20";
            Prestamo prestamo = new Prestamo(est, libro, fPrestamo, fDevolucion);
            prestamos.add(prestamo);
            JOptionPane.showMessageDialog(null, "Préstamo creado.");
        } else {
            JOptionPane.showMessageDialog(null, "Libro no encontrado.");
        }
    }

    private void mostrarEstadoUI() {
        String res = "Estado de la Biblioteca " + nombre + ":\n";
        res += horario.mostrarHorario() + "\n";
        res += "Libros disponibles:\n";
        for (Libro l : libros) {
            res += "- " + l.getTitulo() + "\n";
        }
        res += "Autores registrados:\n";
        for (Autor a : autores) {
            res += "- " + a.getNombre() + "\n";
        }
        res += "Préstamos activos:\n";
        for (Prestamo p : prestamos) {
            res += p.mostrarInfo() + "\n";
        }
        textArea.setText(res);
    }

    private void cerrarBiblioteca() {
        prestamos.clear();
    }

    public void guardar() {
        try (FileOutputStream file = new FileOutputStream("biblioteca.dat");
             ObjectOutputStream sal = new ObjectOutputStream(file)) {
            sal.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Biblioteca cargar() {
        try (FileInputStream file = new FileInputStream("biblioteca.dat");
             ObjectInputStream ent = new ObjectInputStream(file)) {
            return (Biblioteca) ent.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}

class Pagina implements Serializable {
    private static final long serialVersionUID = 1L;
    private int numero;
    private String contenido;

    public Pagina(int numero, String contenido) {
        this.numero = numero;
        this.contenido = contenido;
    }

    public String mostrarPagina() {
        return "Página " + numero + ": " + contenido;
    }
}

class Horario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String diasApertura;
    private String horaApertura;
    private String horaCierre;

    public Horario(String dias, String hApertura, String hCierre) {
        this.diasApertura = dias;
        this.horaApertura = hApertura;
        this.horaCierre = hCierre;
    }

    public String mostrarHorario() {
        return "Horario: " + diasApertura + " de " + horaApertura + " a " + horaCierre;
    }
}

class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titulo;
    private String isbn;
    private java.util.ArrayList<Pagina> paginas;

    public Libro(String titulo, String isbn, String[] contenidosPaginas) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = new java.util.ArrayList<>();
        for (int i = 0; i < contenidosPaginas.length; i++) {
            paginas.add(new Pagina(i + 1, contenidosPaginas[i]));
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String leer() {
        String res = "Leyendo libro: " + titulo + "\n";
        for (Pagina p : paginas) {
            res += p.mostrarPagina() + "\n";
        }
        return res;
    }
}

class Autor implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String mostrarInfo() {
        return "Autor: " + nombre + " (" + nacionalidad + ")";
    }

    public String getNombre() {
        return nombre;
    }
}

class Estudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String nombre;

    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String mostrarInfo() {
        return "Estudiante: " + nombre + " (Código: " + codigo + ")";
    }

    public String getNombre() {
        return nombre;
    }
}

class Prestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private Estudiante estudiante;
    private Libro libro;

    public Prestamo(Estudiante estudiante, Libro libro, String fPrestamo, String fDevolucion) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = fPrestamo;
        this.fechaDevolucion = fDevolucion;
    }

    public String mostrarInfo() {
        return "Préstamo: " + libro.getTitulo() + " a " + estudiante.getNombre() +
               " desde " + fechaPrestamo + " hasta " + fechaDevolucion;
    }
}