package com.example.practice.demo.controller
import com.example.practice.demo.models.User
import com.example.practice.demo.repo.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class SampleController @Autowired constructor(private val userRepo: UserRepo) {



    @GetMapping("/sharuk")
    @ResponseBody
     // Add this annotation to indicate that the return value should be used as the response body
    fun hello(): String {
        return "hello world"
    }


    @PostMapping("/user")
    @ResponseBody
    fun addUserToDB(@RequestBody user: User): User {
        return userRepo.save(user)
    }

    @GetMapping("/users")
    @ResponseBody
    fun getAllUsers() : List<User> {
        return userRepo.findAll()
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    fun getUserById(@PathVariable("id") userId: Long): ResponseEntity<User> {
         val user = userRepo.findById(userId)
        return if (user.isPresent) {
            ResponseEntity.ok(user.get())
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    fun deleteUser(@PathVariable("id") userId: Long){
        if(userRepo.existsById(userId)){
            userRepo.deleteById(userId)
        }
    }
}
