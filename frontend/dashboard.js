document.addEventListener("DOMContentLoaded", () => {
    const token = localStorage.getItem("jwtToken");
    
    if (!token) {
        alert("Unauthorized! Please log in.");
        window.location.href = "index.html";  // Redirect to login if no token
    }

    document.getElementById("logoutButton").addEventListener("click", () => {
        localStorage.removeItem("jwtToken");  // Remove token
        window.location.href = "index.html";  // Redirect to login page
    });
});
