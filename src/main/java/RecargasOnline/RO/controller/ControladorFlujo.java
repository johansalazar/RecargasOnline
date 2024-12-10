package RecargasOnline.RO.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorFlujo {

    @GetMapping("/index")
    public String mostrarPanelControl() {
        return "index";  // Nombre de la vista que se mapea a panelControl.jsp o panelControl.html
    }

    @GetMapping("vendedor")
    public String mostrarVendedor() {
        return "vendedor";  // Redirige a vendedor.jsp o vendedor.html
    }

    @GetMapping("/operador")
    public String mostrarOperador() {
        return "operador";  // Redirige a operador.jsp o operador.html
    }

    @GetMapping("/recarga")
    public String mostrarRecarga() {
        return "recarga";  // Redirige a recarga.jsp o recarga.html
    }
}

