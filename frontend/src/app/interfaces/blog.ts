export interface Blog {

    canonical_url: string;
    content:string;
    collection_id: number | null;
    comments_count: number;
    cover_image: string;
    created_at: string;
    crossposted_at: string | null;
    description: string;
    edited_at: string;
    id: number;
    last_comment_at: string;
    organization: Organization;
    path: string;
    positive_reactions_count: number;
    public_reactions_count: number;
    published_at: string;
    published_timestamp: string;
    readable_publish_date: string;
    reading_time_minutes: number;
    slug: string;
    social_image: string;
    imageUrl:string;
    tag_list: string[];
    tags: string;
    title: string;
    type_of: string;
    url: string;
    user: User;
    
}

interface Organization {
    name: string;
    profile_image: string;
    profile_image_90: string;
  }
  
interface User {
    github_username: string;
    name: string;
    profile_image: string;
    profile_image_90: string;
    twitter_username: string;
    user_id: number;
    username: string;
    website_url: string;
  }
  