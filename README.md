# KLH-FED-2026-16 Smart Parking Lot Management System

A website-based parking management system that automates vehicle check-ins using camera-based License Plate Recognition (ANPR), automatically pulls vehicle details, and manages user sessions via dynamic QR code tickets.

Made by :
Jalla Sai Bhargav - 2620030109;
Karthik Reddy - 2620030056

---

## Key Functionality

* Camera-Based License Plate Scanning: Captures a live feed or snapshot (including phone screen displays) and uses computer vision to detect and extract license plate text.
* Automated Vehicle Information Import: Reroutes extracted plate numbers through public vehicle lookup services to automatically retrieve and store vehicle specs (make, model, and type).
* QR-Gated Web Portal: Dynamically generates a unique QR code ticket at check-in. The website portal is restricted and accessible only by scanning a valid check-in QR code.
* Smart Spot Allocation: Automatically assigns an available parking slot based on vehicle characteristics and tracks lot occupancy in real time.
* Dynamic Fee Ticker: Tracks vehicle entry duration and calculates parking charges in real time.
* Automated Checkout & Logging: Scanning out completes the session, calculates the final fee, frees up the assigned parking spot, and logs the exit history.

---

## System Flow

1. Check-In: Vehicle presents plate to camera -> System reads plate number -> System fetches vehicle make/model -> Spot assigned -> Dynamic QR ticket generated.
2. Driver Access: Driver scans QR code -> Gains access to personalized session web portal (viewing assigned spot, timer, and running fee).
3. Check-Out: Ticket is processed at exit -> Fee settled -> Spot freed in system -> QR session invalidated.

---

## Abstract
Project Title: Multi-Level Parking Lot Manager

Domain: Object-Oriented Software Engineering (Java)

Abstract

Urbanization and the growing number of vehicles have made efficient parking management a critical challenge in modern cities. The Multi-Level Parking Lot Manager is an automated Java-based application designed to streamline parking operations across multi-story facilities, reducing manual effort and traffic congestion.

Built using core Object-Oriented Programming (OOP) principles—including Abstraction, Encapsulation, and Polymorphism—the system dynamically assigns optimal parking spots based on vehicle specifications (Motorcycles, Compact Cars, SUVs, and Electric Vehicles). The application tracks floor-wise spot availability in real-time, generates unique entry tickets upon check-in, and automatically calculates dynamic parking fees upon check-out based on duration and spot type. By offering structured data management and modular design, this system provides a scalable foundation for integration with modern smart-city infrastructures, automated entry gates, and database systems.

Key Slide Bullets (For PPT Presentation)
Problem Statement: Manual parking systems lead to delay, space inefficiency, and lack of real-time tracking across multiple floors.

Proposed Solution: A Java-based automated management system that handles multi-floor allocation, spot type matching, and ticket generation.

Core Technical Features:

Dynamic spot allocation matching vehicle dimensions (Compact, SUV, EV, Motorcycle).

Automated ticket issuance and time-based fee calculation upon exit.

Real-time floor status tracking and spot availability updates.

OOP Concepts Applied: Encapsulation (Ticket/Spot entities), Inheritance & Polymorphism (Vehicle subclasses), and Modular Architecture (ParkingLotManager).
