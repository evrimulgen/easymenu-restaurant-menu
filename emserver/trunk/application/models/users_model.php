<?php
/*
*Copyright 2012 Gianrico D'Angelis  -- gianrico.dangelis@gmail.com
*
*Licensed under the Apache License, Version 2.0 (the "License");
*you may not use this file except in compliance with the License.
*You may obtain a copy of the License at
*
*  http://www.apache.org/licenses/LICENSE-2.0
*
*Unless required by applicable law or agreed to in writing, software
*distributed under the License is distributed on an "AS IS" BASIS,
*WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*See the License for the specific language governing permissions and
*limitations under the License.
*/

class Users_model extends CI_Model {
	
	function countUsers(){		
		//$this->db->where('username <>','admin');
		return $this->db->count_all_results('users');	
	}
	
	function getUsers(){
		
		$this->db->select('users.*,roles.label as roleLabel');
		$this->db->from('users');
		$this->db->join('roles','users.role=roles.idRoles');
		//$this->db->where('username <>','admin');
		$query=$this->db->get();
		
		return $query->result();
	}
	
	function getJSONUserByID($idUsers){
		$query = $this->db->get_where('users',array('idUsers'=>$idUsers));
		return json_encode($query->result());
	}
	
	function saveUser($data){
		
		$this->db->insert('users',$data);
	}
	
	function updateUser($data){
		$this->db->where('idUsers',$data['idUsers']);
		$this->db->update('users',$data);
	}
	
	function deleteUser($idUsers){
		$this->db->where('idUsers',$idUsers);
		$this->db->delete('users');
	}
}

?>