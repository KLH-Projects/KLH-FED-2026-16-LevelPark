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
================================================================================
          CLASSROOM / PARKING SLOT ALLOCATION SIMULATOR
                  USER INPUT & CELL GUIDE MANUAL
================================================================================

1. OVERVIEW OF SYSTEM ENTITIES
--------------------------------------------------------------------------------
The system operates by mapping unique Allocation Tokens (representing students,
vehicles, or items) to specific Grid Cells (representing target slots/seats).

• ALLOCATION TOKENS: Identifier string matching pattern [A-Z]+-\d{2}
  - ORBIT-07  (Primary test token)
  - NOVA-12   (Secondary test token)
  - PIXEL-04  (Tertiary test token)

• GRID CELL IDENTIFIERS: Slot labels matching pattern [A-B]-0[1-6]
  - GRID-A: Main grid block containing cells A-01 through A-06
  - GRID-B: Secondary grid block containing cell B-01

--------------------------------------------------------------------------------
2. MASTER LIST OF VALID GRID CELLS
--------------------------------------------------------------------------------
Cell Label   Grid Name    Default Capacity   Associated Module Usage
--------------------------------------------------------------------------------
A-01         GRID-A       1 Seat / Spot      Weeks 6, 7, 8
A-02         GRID-A       1 Seat / Spot      Weeks 2, 3, 6, 7, 8, 10, 11, 12
A-03         GRID-A       1 Seat / Spot      Weeks 4, 6, 7, 8, 11, 12
A-04         GRID-A       1 Seat / Spot      Weeks 5, 6, 7, 8
A-05         GRID-A       1 Seat / Spot      Weeks 7, 8
A-06         GRID-A       1 Seat / Spot      Weeks 7, 8
B-01         GRID-B       1 Seat / Spot      Weeks 9, 10, 12

--------------------------------------------------------------------------------
3. INPUT COMMAND MANUAL & SYNTAX RULES
--------------------------------------------------------------------------------

[COMMAND 1]: Allocation Request
  • Format : ALLOCATE <TOKEN> <CELL>
  • Usage  : Assigns an unallocated token to an empty cell.
  • Rules  : 
             1. <TOKEN> must consist of capital letters, a hyphen, and 2 digits.
             2. <CELL> must exist within GRID-A (A-01 to A-06) or GRID-B (B-01).
             3. Duplicate tokens and already occupied cells will be rejected.
  • Examples:
             ALLOCATE ORBIT-07 A-02   --> ACCEPTED
             ALLOCATE NOVA-12 A-03    --> ACCEPTED
             ALLOCATE PIXEL-04 B-01   --> ACCEPTED

[COMMAND 2]: Deallocation / Release Request
  • Format : RELEASE <CELL>
  • Usage  : Frees up an occupied cell, making it available for new allocation.
  • Rules  : <CELL> must be currently occupied. Releasing a free cell has no effect.
  • Examples:
             RELEASE A-02             --> ACCEPTED (Frees cell A-02)
             RELEASE A-03             --> ACCEPTED (Frees cell A-03)

[COMMAND 3]: Grid Search & Inspection
  • Format : SEARCH <TARGET>
  • Usage  : Searches for a token string or cell label to return occupancy status.
  • Examples:
             SEARCH A-02              --> Returns token occupying cell A-02
             SEARCH ORBIT-07          --> Returns cell assigned to ORBIT-07

--------------------------------------------------------------------------------
4. ACCEPTED VS. REJECTED INPUT TRACE EXAMPLES
--------------------------------------------------------------------------------

Input Command             Result      System Reason / Error Message
--------------------------------------------------------------------------------
ALLOCATE ORBIT-07 A-02    ACCEPTED    Valid token format and available cell.
ALLOCATE ORBIT-07 A-03    REJECTED    Rejected: duplicate token ORBIT-07.
ALLOCATE NOVA-12 A-99     REJECTED    Rejected: cell A-99 is outside GRID-A.
ALLOCATE ORBIT-07 GRID-X  REJECTED    Rejected command: Unknown grid label.
ALLOCATE "" A-02          REJECTED    Rejected command: Token is blank.

--------------------------------------------------------------------------------
5. PERSISTENCE FILE FORMAT (simulator-state.csv)
--------------------------------------------------------------------------------
When saving state (Week 11 & Week 12), data is exported in standard CSV format:

token,cell
ORBIT-07,A-02
NOVA-12,A-03
PIXEL-04,B-01

================================================================================
END OF GUIDE MANUAL
================================================================================
