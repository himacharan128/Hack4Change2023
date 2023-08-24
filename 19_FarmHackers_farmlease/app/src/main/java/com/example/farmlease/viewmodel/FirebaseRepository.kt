package com.example.farmlease.viewmodel
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirebaseRepository {

    private val db = FirebaseFirestore.getInstance()

    suspend fun addUser(user: User) {
        db.collection("userDB").document(user.userId).set(user).await()
    }

    suspend fun addProduct(product: Product) {
        db.collection("productDB").document(product.productId).set(product).await()
    }

    suspend fun addProductToOwnedProducts(userId: String, productId: String) {
        db.collection("userDB")
            .document(userId)
            .update("ownedProducts", FieldValue.arrayUnion(productId))
            .await()
    }

    suspend fun removeProductFromOwnedProducts(userId: String, productId: String) {
        db.collection("userDB")
            .document(userId)
            .update("ownedProducts", FieldValue.arrayRemove(productId))
            .await()
    }

    suspend fun addProductToBorrowedProducts(userId: String, productId: String) {
        db.collection("userDB")
            .document(userId)
            .update("borrowedProducts", FieldValue.arrayUnion(productId))
            .await()
    }

    suspend fun removeProductFromBorrowedProducts(userId: String, productId: String) {
        db.collection("userDB")
            .document(userId)
            .update("borrowedProducts", FieldValue.arrayRemove(productId))
            .await()
    }

    suspend fun getAllUsers(): List<User> {
        val querySnapshot = db.collection("userDB").get().await()
        return querySnapshot.toObjects(User::class.java)
    }

    suspend fun getAllProducts(): List<Product> {
        val querySnapshot = db.collection("productDB").get().await()
        return querySnapshot.toObjects(Product::class.java)
    }

    suspend fun getUserById(userId: String): User? {
        val documentSnapshot = db.collection("userDB").document(userId).get().await()
        return documentSnapshot.toObject(User::class.java)
    }

    suspend fun getProductById(productId: String): Product? {
        val documentSnapshot = db.collection("productDB").document(productId).get().await()
        return documentSnapshot.toObject(Product::class.java)
    }

    suspend fun getOwnedProductsForUser(userId: String): List<Product> {
        val userDocument = db.collection("userDB").document(userId).get().await()
        val user = userDocument.toObject(User::class.java)

        val ownedProductIds = user?.ownedProducts ?: emptyList()

        val ownedProducts = mutableListOf<Product>()

        ownedProductIds.forEach { productId ->
            val productDocument = db.collection("productDB").document(productId).get().await()
            val product = productDocument.toObject(Product::class.java)
            product?.let { ownedProducts.add(it) }
        }

        return ownedProducts
    }

    suspend fun getBorrowedProductsForUser(userId: String): List<Product> {
        val userDocument = db.collection("userDB").document(userId).get().await()
        val user = userDocument.toObject(User::class.java)

        val borrowedProductIds = user?.borrowedProducts ?: emptyList()

        val borrowedProducts = mutableListOf<Product>()

        borrowedProductIds.forEach { productId ->
            val productDocument = db.collection("productDB").document(productId).get().await()
            val product = productDocument.toObject(Product::class.java)
            product?.let { borrowedProducts.add(it) }
        }

        return borrowedProducts
    }

}


