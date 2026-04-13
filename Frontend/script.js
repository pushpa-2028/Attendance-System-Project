function login() {
    let user = document.getElementById("username").value;
    let pass = document.getElementById("password").value;

    if (user === "admin" && pass === "1234") {
        window.location.href = "dashboard.html";
    } else {
        alert("Invalid login");
    }
    return false;
}

function addStudent() {
    let name = document.getElementById("name").value;
    let usn = document.getElementById("usn").value;

    alert("Student Added: " + name + " (" + usn + ")");
    return false;
}

function markAttendance() {
    let id = document.getElementById("studentId").value;
    let status = document.getElementById("status").value;

    alert("Attendance Marked: ID " + id + " - " + status);
    return false;
}