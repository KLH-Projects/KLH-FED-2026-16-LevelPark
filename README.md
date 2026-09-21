# KLH-FED-2026-16 Smart Parking Lot Management System

A website-based parking management system that automates vehicle check-ins using camera-based License Plate Recognition (ANPR), automatically pulls vehicle details, and manages user sessions via dynamic QR code tickets.

Made by :
Jalla Sai Bhargav - 2620030109
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
