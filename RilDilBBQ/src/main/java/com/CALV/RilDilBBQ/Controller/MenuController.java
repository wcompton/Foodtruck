package com.CALV.RilDilBBQ.Controller;

// import com.gcu235.demo.ResourceNotFoundException;
import com.CALV.RilDilBBQ.Menu;
import com.CALV.RilDilBBQ.MenuRepository;
import com.CALV.RilDilBBQ.Exception.ResourceNotFoundException;
import com.CALV.RilDilBBQ.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

 // Get All Menus
    @GetMapping("/menu")
    public List<Menu> getAllMenuItems() {
        return menuRepository.findAll();
    }

 // Create a new Menu
    @PostMapping("/menu")
    public Menu createMenu(@Valid @RequestBody Menu menuItems) {
        return menuRepository.save(menuItems);
    }

 // Get a Single Menu
    @GetMapping("/menu/{id}")
    public Menu getMenuById(@PathVariable(value = "id") Long menuId) {
        return menuRepository.findById(menuId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu", "id", menuId));
    }

 // Update a Menu
    @PutMapping("/menu/{id}")
    public Menu updateMenu(@PathVariable(value = "id") Long menuId,
                                            @Valid @RequestBody Menu menuDetails) {

        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu", "id", menuId));

        menu.setMenuItem(menuDetails.getMenuItem());
        menu.setDescription(menuDetails.getDescription());

        Menu updatedMenu = menuRepository.save(menu);
        return updatedMenu;
    }

 // Delete a Menu
    @DeleteMapping("/menu/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable(value = "id") Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new ResourceNotFoundException("Menu", "id", menuId));

        menuRepository.delete(menu);

        return ResponseEntity.ok().build();
    }
}