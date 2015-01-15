<div id="userDetails">
	<h2>{{user.name}}</h2>
	<img ng-src="{{user.avatar_url}}" title="{{user.name}}" width="200px"
		height="200px"> Order: <select ng-model="repoSortOrder">
		<option value="+name">Name</option>
		<option value="-stargazers_count">Stars</option>
		<option value="+language">Language</option>
	</select>
</div>

<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Stars</th>
			<th>Language</th>
		</tr>
	</thead>
	<tbody>
		<tr ng-repeat="repo in repos | orderBy:repoSortOrder">
			<td>{{repo.name}}</td>
			<td>{{repo.stargazers_count | number}}</td>
			<td>{{repo.language}}</td>
		</tr>
	</tbody>
</table>