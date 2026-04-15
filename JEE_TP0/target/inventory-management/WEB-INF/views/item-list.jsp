<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des articles</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #2196F3; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        a.btn { padding: 5px 10px; background: #008CBA; color: white; text-decoration: none; border-radius: 3px; }
        a.btn-danger { background: #f44336; }
        a.btn-add { background: #4CAF50; display: inline-block; margin-bottom: 15px; padding: 8px 16px; }
        .low-stock { color: red; font-weight: bold; }
    </style>
</head>
<body>
<h1>Gestion du Stock</h1>
<a class="btn btn-add" href="item-form">+ Nouvel article</a>
<a class="btn" href="users" style="margin-left:10px;">Voir les utilisateurs</a>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Titre</th>
        <th>SKU</th>
        <th>Catégorie</th>
        <th>Prix unitaire</th>
        <th>Quantité</th>
        <th>Seuil réappro.</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.id}</td>
            <td>${item.title}</td>
            <td>${item.skuCode}</td>
            <td>${item.category}</td>
            <td>${item.unitPrice} €</td>
            <td class="${item.quantityInStock <= item.reorderThreshold ? 'low-stock' : ''}">${item.quantityInStock}</td>
            <td>${item.reorderThreshold}</td>
            <td>
                <a class="btn" href="item-form?action=edit&id=${item.id}">Modifier</a>
                <a class="btn btn-danger" href="delete-item?id=${item.id}"
                   onclick="return confirm('Supprimer cet article ?')">Supprimer</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty items}">
        <tr><td colspan="8" style="text-align:center">Aucun article en stock.</td></tr>
    </c:if>
    </tbody>
</table>
</body>
</html>
