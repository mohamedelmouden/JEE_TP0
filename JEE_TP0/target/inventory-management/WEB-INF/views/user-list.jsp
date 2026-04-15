<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des utilisateurs</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #4CAF50; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        a.btn { padding: 5px 10px; background: #008CBA; color: white; text-decoration: none; border-radius: 3px; }
        a.btn-danger { background: #f44336; }
        a.btn-add { background: #4CAF50; display: inline-block; margin-bottom: 15px; padding: 8px 16px; }
    </style>
</head>
<body>
<h1>Gestion des Utilisateurs</h1>
<a class="btn btn-add" href="user-form">+ Nouvel utilisateur</a>
<a class="btn" href="items" style="margin-left:10px;">Voir les articles</a>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Prénom</th>
        <th>Nom</th>
        <th>Email</th>
        <th>Rôle</th>
        <th>Actif</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <td>${user.active ? 'Oui' : 'Non'}</td>
            <td>
                <a class="btn" href="user-form?action=edit&id=${user.id}">Modifier</a>
                <a class="btn btn-danger" href="delete-user?id=${user.id}"
                   onclick="return confirm('Supprimer cet utilisateur ?')">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty users}">
        <tr><td colspan="7" style="text-align:center">Aucun utilisateur trouvé.</td></tr>
    </c:if>
    </tbody>
</table>
</body>
</html>
