
package com.modern.movieappmvvm.Gitapp.ui


data class GitRepoList(val items:ArrayList<GitRepoData>)
data class GitRepoData(val name:String, val description:String, val owner: com.modern.movieappmvvm.Gitapp.ui.Owner)
data class Owner(val avatar_url:String)