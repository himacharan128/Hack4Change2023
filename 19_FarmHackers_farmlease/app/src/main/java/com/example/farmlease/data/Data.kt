package com.example.farmlease.data

import com.example.farmlease.R
import com.example.farmlease.schemas.Owner
import com.example.farmlease.schemas.LeaseItem
import com.example.farmlease.schemas.LeaseItemType

val owner1 = Owner("Ranga Rao", "83648363778")
val owner2 = Owner("Shiva Kurman", "7276484647")
val owner3 = Owner("Meera Gupta", "9837264637")
val owner4 = Owner("Vikram Singh", "8765432190")
val owner5 = Owner("Aishwarya Sharma", "7890123456")
val owner6 = Owner("Rajesh Patel", "9123456789")
val owner7 = Owner("Pooja Verma", "8654321987")
val owner8 = Owner("Suresh Kumar", "9988776655")
val owner9 = Owner("Neha Yadav", "7456123890")
val owner10 = Owner("Harish Tiwari", "6382749501")
val owner11 = Owner("Anjali Rajput", "9876543210")
val owner12 = Owner("Arun Khanna", "7298374650")
val owner13 = Owner("Divya Malhotra", "8765432987")
val owner14 = Owner("Sanjay Choudhury", "9867234567")
val owner15 = Owner("Rani Mishra", "7896543210")
val owner16 = Owner("Kamal Kumar", "8765432189")
val owner17 = Owner("Preeti Singhania", "9078563412")
val owner18 = Owner("Vijay Sharma", "8765432109")
val owner19 = Owner("Rohit Verma", "7896541230")
val owner20 = Owner("Priya Kapoor", "8765432198")


val leaseItemsList = mutableListOf<LeaseItem>(
    LeaseItem(
        itemName = "SY.NO.19872",
        price = 46000,
        address = "alkapuri phase 1",
        desc = "Residential property",
        owner = owner1,
        landArea = 5,
        type = LeaseItemType.LAND,
        img = R.drawable.land
    ),
    LeaseItem(
        itemName = "SY.NO.19845",
        price = 50000,
        address = "Varanasi Road",
        desc = "Residential property near Ganges",
        owner = owner1,
        landArea = 7,
        type = LeaseItemType.LAND,
        img = R.drawable.land2
    ),
    LeaseItem(
        itemName = "SY.NO.19865",
        price = 7500000,
        address = "Agra, Uttar Pradesh",
        desc = "Luxury apartment with a view of the Taj Mahal",
        owner = owner2,
        landArea = 3,
        type = LeaseItemType.LAND,
        img = R.drawable.land3
    ),LeaseItem(
        itemName = "SY.NO.23424",
        price = 20000,
        address = "Calangute Beach, Goa",
        desc = "Beachfront vacation rental",
        owner = owner3,
        landArea = 4,
        type = LeaseItemType.LAND ,
        img = R.drawable.land2
    ),
    LeaseItem(
        itemName = "SY.NO.35343",
        price = 150000,
        address = "Munnar, Kerala",
        desc = "Tea plantation for lease",
        owner = owner4,
        landArea = 10,
        type = LeaseItemType.LAND,
        img = R.drawable.land3
    ),
    LeaseItem(
        itemName = "SY.NO.56355",
        price = 1000000,
        address = "Jaipur, Rajasthan",
        desc = "Historic haveli for events and stays",
        owner = owner5,
        landArea = 6,
        type = LeaseItemType.LAND,
        img = R.drawable.land
    ),
    LeaseItem(
        itemName = "SY.NO.23223",
        price = 60000,
        address = "Mysore, Karnataka",
        desc = "Fruit orchard for lease",
        owner = owner6,
        landArea = 5,
        type = LeaseItemType.LAND
    ),
    LeaseItem(
        itemName = "Land with long desc",
        price = 50000,
        address = "123 Main St, Near some park in some city, in some galli, this is just long",
        desc = "This is a very very long description. It is supposed to contain " +
                "a few notes by the user. What kind of notes? Maybe a few conditions" +
                " and hopefully a few perks!" + "This is a very very long description. It is supposed to contain " +
                "a few notes by the user. What kind of notes? Maybe a few conditions" +
                " and hopefully a few perks!",
        owner = owner1,
        landArea = 500,
        type = LeaseItemType.LAND,
        img = R.drawable.land3
    ),
    LeaseItem(
        itemName = "Mahindra Tractor",
        price = 1500,
        address = "Tellapur",
        owner = owner1,
        type = LeaseItemType.EQUIPMENT,
        img = R.drawable.harvestingmachine
    ),
    LeaseItem(
        itemName = "John Deere Harvesting Machine",
        price = 2000,
        address = "Nashik",
        owner = owner2,
        type = LeaseItemType.EQUIPMENT,
        img = R.drawable.tractor
    ),
    LeaseItem(
        itemName = "Tata Borewell Machine",
        price = 1800,
        address = "Jaipur",
        owner = owner3,
        type = LeaseItemType.EQUIPMENT,
        img = R.drawable.harvestingmachine
    ),
    LeaseItem(
        itemName = "Mahindra Borewell Machine",
        price = 1900,
        address = "Coimbatore",
        owner = owner6,
        type = LeaseItemType.EQUIPMENT,
        img = R.drawable.tractor
    ),
    LeaseItem(
        itemName = "Kubota Tractor",
        price = 1600,
        address = "Surat",
        owner = owner7,
        type = LeaseItemType.EQUIPMENT,
        img = R.drawable.harvestingmachine
    ),
    LeaseItem(
        itemName = "CLAAS Harvesting Machine",
        price = 2400,
        address = "Amritsar",
        owner = owner8,
        type = LeaseItemType.EQUIPMENT,
        img = R.drawable.tractor
    ),
    LeaseItem(
        itemName = "Ashok Leyland Borewell Machine",
        price = 2000,
        address = "Bengaluru",
        owner = owner9,
        type = LeaseItemType.EQUIPMENT,
        img = R.drawable.harvestingmachine
    ),
    LeaseItem(
        itemName = "Massey Ferguson Tractor",
        price = 1700,
        address = "Pune",
        owner = owner10,
        type = LeaseItemType.EQUIPMENT,
        img = R.drawable.tractor
    ),

    LeaseItem(
        itemName = "Kirloskar Borewell Machine",
        price = 2100,
        address = "Hyderabad",
        owner = owner12,
        type = LeaseItemType.EQUIPMENT,
        img = R.drawable.harvestingmachine
    ),
    LeaseItem(
        itemName = "Rajesh Yadav",
        price = 800,
        address = "12 Industrial Lane, Mumbai",
        desc = "Skilled labor for manufacturing",
        owner = owner1,
        type = LeaseItemType.LABOUR,
        img = R.drawable.farm_lease_logo
    ),
    LeaseItem(
        itemName = "Sarita Mishra",
        price = 1500,
        address = "45 Industrial Avenue, Chennai",
        desc = "Experienced labor for welding and fabrication",
        owner = owner2,
        type = LeaseItemType.LABOUR,
        img = R.drawable.farm_lease_logo
    ),
    LeaseItem(
        itemName = "Amit Singh",
        price = 700,
        address = "78 Factory Road, Delhi",
        desc = "Laborer for general industrial work",
        owner = owner3,
        type = LeaseItemType.LABOUR,
        img = R.drawable.farm_lease_logo
    ),
    LeaseItem(
        itemName = "Meena Gupta",
        price = 550,
        address = "9 Factory Lane, Pune",
        desc = "General labor for industrial cleaning",
        owner = owner6,
        type = LeaseItemType.LABOUR,
        img = R.drawable.farm_lease_logo
    ),
    LeaseItem(
        itemName = "Vikram Verma",
        price = 1750,
        address = "67 Industrial Zone, Hyderabad",
        desc = "Specialized labor for electrical maintenance",
        owner = owner7,
        type = LeaseItemType.LABOUR,
        img = R.drawable.farm_lease_logo
    ),

    LeaseItem(
        itemName = "Sri Venkateswara Cold Storage",
        price = 1800,
        address = "34 Ice Avenue, Chennai",
        owner = owner1,
        type = LeaseItemType.STORAGE,
        img = R.drawable.coldstorage1
    ),
    LeaseItem(
        itemName = "Maa Durga Refrigeration",
        price = 1500,
        address = "21 Freezer Lane, Kolkata",
        owner = owner2,
        type = LeaseItemType.STORAGE,
        img = R.drawable.coldstorage2
    ),
    LeaseItem(
        itemName = "Shree Ram Cold Storage",
        price = 1700,
        address = "56 Chilled Street, Jaipur",
        owner = owner3,
        type = LeaseItemType.STORAGE,
        img = R.drawable.coldstorage1
    ),
    LeaseItem(
        itemName = "Krishna Cold Storage Solutions",
        price = 1900,
        address = "78 Frost Road, Mumbai",
        owner = owner4,
        type = LeaseItemType.STORAGE,
        img = R.drawable.coldstorage2
    ),
    LeaseItem(
        itemName = "Amrit Cold Storage",
        price = 1600,
        address = "45 Iceberg Avenue, Amritsar",
        owner = owner5,
        type = LeaseItemType.STORAGE,
        img = R.drawable.coldstorage1
    ),
    LeaseItem(
        itemName = "Ganga Deep Freezers",
        price = 1750,
        address = "67 Cool Lane, Varanasi",
        owner = owner6,
        type = LeaseItemType.STORAGE,
        img = R.drawable.coldstorage2
    ),

    LeaseItem(
        itemName = "Ashok Leyland Lorry",
        price = 19050,
        address = "89 Frosty Lane, Chennai",
        owner = owner1,
        type = LeaseItemType.TRANSPORT,
        img = R.drawable.lorry1
    ),
    LeaseItem(
        itemName = "Tata DCM",
        price = 22000,
        address = "45 Cargo Street, Mumbai",
        owner = owner2,
        type = LeaseItemType.TRANSPORT,
        img = R.drawable.tractor
    ),
    LeaseItem(
        itemName = "BharatBenz 3723R Truck",
        price = 24000,
        address = "23 Haul Road, Jaipur",
        owner = owner12,
        type = LeaseItemType.TRANSPORT,
        img = R.drawable.tractor
    ),
    LeaseItem(
        itemName = "Eicher Pro 1110 Truck",
        price = 17000,
        address = "45 Hauling Lane, Bengaluru",
        owner = owner15,
        type = LeaseItemType.TRANSPORT,
        img = R.drawable.lorry1
    ),
    LeaseItem(
        itemName = "Mahindra Furio Lorry",
        price = 15500,
        address = "34 Load Avenue, Chennai",
        owner = owner16,
        type = LeaseItemType.TRANSPORT,
        img = R.drawable.lorry1
    ),


)

val userLeasedItems: MutableList<Int> = mutableListOf(
        leaseItemsList[9].id,
        leaseItemsList[12].id,
        leaseItemsList[8].id,
)

val userOwnedItems: MutableList<Int> = mutableListOf(
    leaseItemsList[1].id,
    leaseItemsList[2].id,
    leaseItemsList[5].id,
)