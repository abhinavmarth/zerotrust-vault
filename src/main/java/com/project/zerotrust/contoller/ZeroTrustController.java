package com.project.zerotrust.contoller;

import org.springframework.data.domain.Page;
import com.project.zerotrust.model.ZeroTrustModel;
import com.project.zerotrust.service.ZeroTrustService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/zerotrust")
 // optional for frontend calls
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
    public ResponseEntity<?> getByUserAndTitle(@RequestParam String user, @RequestParam String title) {
        ZeroTrustModel model = zeroTrustService.getbyuserandtitle(user, title);
        if (model == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record found for given user and title");
        }
        return ResponseEntity.ok(model);
    }


    @GetMapping("/vaults")
    public Page<ZeroTrustModel> getVaults(HttpServletRequest request,@RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size) {
        String uid = (String) request.getAttribute("firebaseUid");
        return zeroTrustService.getUserVaults(uid,PageRequest.of(page, size));
    }
}
