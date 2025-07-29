package com.project.zerotrust.contoller;

import com.project.zerotrust.model.ZeroTrustModel;
import com.project.zerotrust.service.ZeroTrustService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zerotrust")
@CrossOrigin(origins = "*") // optional for frontend calls
public class ZeroTrustController {

    @Autowired
    private ZeroTrustService zeroTrustService;

    @GetMapping("/{id}")
    public ResponseEntity<ZeroTrustModel> getById(@PathVariable Long id){
        return new ResponseEntity<>(zeroTrustService.getbyId(id), HttpStatus.OK);
    }

    @PostMapping
    public ZeroTrustModel add(@RequestBody ZeroTrustModel zeroTrustModel, HttpServletRequest request){
        String uid = (String) request.getAttribute("firebaseUid");
        return zeroTrustService.create(zeroTrustModel, uid);
    }


    @GetMapping
    public ResponseEntity<List<ZeroTrustModel>> getAll(){
        return new ResponseEntity<>(zeroTrustService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<ZeroTrustModel> getByUser(@RequestParam String name){
        return new ResponseEntity<>(zeroTrustService.getbyUser(name), HttpStatus.OK);
    }

    @GetMapping("/user-title")
    public ResponseEntity<ZeroTrustModel> getByUserAndTitle(@RequestParam String user, @RequestParam String title){
        return new ResponseEntity<>(zeroTrustService.getbyuserandtitle(user, title), HttpStatus.OK);
    }

    @GetMapping("/vaults")
    public ResponseEntity<?> getVaults(HttpServletRequest request) {
        String uid = (String) request.getAttribute("firebaseUid");
        List<ZeroTrustModel> userVaults = zeroTrustService.findByuseriId(uid);
        return ResponseEntity.ok(userVaults);
    }
}
