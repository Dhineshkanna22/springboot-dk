package net.javaguides.springboot_app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.javaguides.springboot_app.Model.Product;

@Repository
public interface Repo extends JpaRepository<Product, Integer>{

    @Query("SELECT p FROM Product p WHERE " +
   "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
   "LOWER(p.desc) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +  // Changed from description to desc
   "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
   "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Product> searchProduct(String keyword);
}
